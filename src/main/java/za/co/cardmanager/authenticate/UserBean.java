package za.co.cardmanager.authenticate;

import java.io.Serializable;

import javax.enterprise.context.SessionScoped;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;

import za.co.cardmanager.utils.SessionUtils;


@SessionScoped
@ManagedBean
public class UserBean implements Serializable {

	    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
		private String name = null;
	    private String password = null;

	    public String getName() {
	        return name;
	    }
	    public void setName(String name) {
	        this.name = name;
	    }
	    public String getPassword() {
	        return password;
	    }
	    public void setPassword(String password) {
	        this.password = password;
	    }

	    public String login(){
	        // Image here a database access to validate the users
	        if (name.equalsIgnoreCase("tester") && password.equalsIgnoreCase("tester")){
	        	HttpSession session = SessionUtils.getSession();
				session.setAttribute("username", name);
	            return "cardlist";
	        } else {
	    		FacesContext.getCurrentInstance().addMessage(
						null,
						new FacesMessage(FacesMessage.SEVERITY_WARN,
								"Incorrect Username and Passowrd",
								"Please enter correct username and Password"));
				
	            return "failed";
	        }

	    }
  

		//logout event, invalidate session
		public String logout() {
			HttpSession session = SessionUtils.getSession();
			session.invalidate();
			return "welcome";
		}
	}


