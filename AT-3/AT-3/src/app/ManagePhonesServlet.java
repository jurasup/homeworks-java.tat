package app;

import java.io.IOException;
import java.sql.SQLException;
import java.util.HashMap;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ManagePhonesServlet extends HttpServlet {
	
	// Основной объект, хранящий данные телефонной книги.
	private Phonebook phonebook;
	//ID редактируемого человека
	private String id;
	
	public ManagePhonesServlet() {
		super();
		// Создание экземпляра телефонной книги.
        try	{
			this.phonebook = Phonebook.getInstance();
		}
		catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		catch (SQLException e) {
			e.printStackTrace();
		}        
	}
	
	//Проверка номера на корректность. Возвращает сообщение об ошибке в случае невалидного номера.
	private String checkPhoneForErrors(Person person, String phone) {
		if (person.validatePhone(phone)) {
			return "";
		} else {
			return "Номер должен начинаться с +/-/# и содержать от 2 до 50 символов";
		}
	}

	// Реакция на GET-запросы.
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		request.setCharacterEncoding("UTF-8");
		
		// Хранилище параметров для передачи в JSP.
		HashMap<String,String> jsp_parameters = new HashMap<String,String>();

		// Диспетчеры для передачи управления на разные JSP (разные представления (view)).
		RequestDispatcher dispatcher_for_person = request.getRequestDispatcher("/ManagePerson.jsp");
        RequestDispatcher dispatcher_for_phone = request.getRequestDispatcher("/ManagePhone.jsp");

		// Действие (action), идентификатор записи (id), идентификатор номера (phone_id)
        // над которыми выполняется это действие.
		String action = request.getParameter("action");
		String id = request.getParameter("id");
		String phone_id = request.getParameter("phone_id");
		// Извлечение из телефонной книги информации о редактируемой записи.        			
		Person editable_person = this.phonebook.getPerson(id);
			
		if (action != null) {
        	switch (action) {
        		// Добавление телефона.
        		case "add":  			
        			// Подготовка параметров для JSP.
        			jsp_parameters.put("current_action", "add");
        			jsp_parameters.put("next_action", "add_go");
        			jsp_parameters.put("next_action_label", "Добавить номер");
        			
        			// Установка параметров JSP.
        			request.setAttribute("person", editable_person);
        			request.setAttribute("jsp_parameters", jsp_parameters);
        			
        			// Передача запроса в JSP.
        			dispatcher_for_phone.forward(request, response);
        		break;
			
        		// Редактирование записи.
        		case "edit":        			
        			// Подготовка параметров для JSP.
        			jsp_parameters.put("current_action", "edit");
        			jsp_parameters.put("next_action", "edit_go");
        			jsp_parameters.put("next_action_label", "Сохранить номер");
        			jsp_parameters.put("phone_id", phone_id);

        			// Установка параметров JSP.
        			request.setAttribute("person", editable_person);
        			request.setAttribute("jsp_parameters", jsp_parameters);
        			
        			// Передача запроса в JSP.
        			dispatcher_for_phone.forward(request, response);
	       		break;
				
	       		// Удаление записи.
	       		case "delete":	       			
	       			editable_person.deletePhone(phone_id);
	       			phonebook.deletePhone(editable_person.getId(), phone_id);
	       			jsp_parameters.put("current_action", "edit");
        			jsp_parameters.put("next_action", "edit_go");
        			jsp_parameters.put("next_action_label", "Сохранить");
	        		// Установка параметров JSP.
        			request.setAttribute("person", editable_person);
        			request.setAttribute("jsp_parameters", jsp_parameters);
        			
        			// Передача запроса в JSP.
        			dispatcher_for_person.forward(request, response);
       			break;
       		}
        }		
	}	
	
	
	// Реакция на POST-запросы.
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		request.setCharacterEncoding("UTF-8");
			
		// Хранилище параметров для передачи в JSP.
		HashMap<String,String> jsp_parameters = new HashMap<String,String>();

		// Диспетчеры для передачи управления на разные JSP (разные представления (view)).
		RequestDispatcher dispatcher_for_person = request.getRequestDispatcher("/ManagePerson.jsp");
		RequestDispatcher dispatcher_for_phone = request.getRequestDispatcher("/ManagePhones.jsp");
			
			
		// Действие (add_go, edit_go) и идентификатор записи (id) над которой выполняется это действие.
		String add_go = request.getParameter("add_go");
		String edit_go = request.getParameter("edit_go");
		String id = request.getParameter("id");
			
		// Добавление записи.
		if (add_go != null)
		{
			// Создание записи на основе данных из формы.
			String phone = request.getParameter("number");
			Person person = (Person)request.getAttribute("person");

			// Валидация номера.
			String error_message = this.checkPhoneForErrors(person, phone);
				
			// Если данные верные, можно производить добавление.
			if (error_message.equals(""))
			{
				person.addPhone(phone);
				phonebook.addPhone(person.getId(), phone);
				// Подготовка параметров для JSP.
				jsp_parameters.put("current_action", "edit");
				jsp_parameters.put("next_action", "edit_go");
				jsp_parameters.put("next_action_label", "Сохранить");
				// Установка параметров JSP.
				request.setAttribute("jsp_parameters", jsp_parameters);
				request.setAttribute("person", person);
		        
				// Передача запроса в JSP.
				dispatcher_for_person.forward(request, response);
			}
			// Если в данных были ошибки, надо заново показать форму и сообщить об ошибках.
			else
			{
	    		// Подготовка параметров для JSP.
	    		jsp_parameters.put("current_action", "add");
	    		jsp_parameters.put("next_action", "add_go");
	    		jsp_parameters.put("next_action_label", "Добавить");
	    		jsp_parameters.put("error_message", error_message);
	    		
	    		// Установка параметров JSP.
	    		request.setAttribute("person", person);
	    		request.setAttribute("jsp_parameters", jsp_parameters);
	    			
	    		// Передача запроса в JSP.
	    		dispatcher_for_phone.forward(request, response);
			}
		}
			
		// Редактирование записи.
		if (edit_go != null)
		{
			// Создание записи на основе данных из формы.
			String phone = request.getParameter("number");
			Person person = (Person)request.getAttribute("person");
			String phone_id = (String)request.getAttribute("phone_id");

			// Валидация номера.
			String error_message = this.checkPhoneForErrors(person, phone); 
			
			// Если данные верные, можно производить добавление.
			if (error_message.equals(""))
			{
				person.editPhone(phone_id, phone);
				phonebook.editPhone(person.getId(), phone, phone_id);

				// Подготовка параметров для JSP.
				jsp_parameters.put("current_action", "edit");
				jsp_parameters.put("next_action", "edit_go");
				jsp_parameters.put("next_action_label", "Сохранить");
				// Установка параметров JSP.
				request.setAttribute("jsp_parameters", jsp_parameters);
				request.setAttribute("person", person);
		        
				// Передача запроса в JSP.
				dispatcher_for_person.forward(request, response);
			}
			// Если в данных были ошибки, надо заново показать форму и сообщить об ошибках.
			else
			{
				// Подготовка параметров для JSP.
	    		jsp_parameters.put("current_action", "add");
	    		jsp_parameters.put("next_action", "add_go");
	    		jsp_parameters.put("next_action_label", "Добавить");
	    		jsp_parameters.put("error_message", error_message);
	    		
	    		// Установка параметров JSP.
	    		request.setAttribute("person", person);
	    		request.setAttribute("jsp_parameters", jsp_parameters);
	    			
	    		// Передача запроса в JSP.
	    		dispatcher_for_phone.forward(request, response);	    			
			}
		}
	}
	
}
