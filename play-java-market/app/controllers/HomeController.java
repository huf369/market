package controllers;

import java.util.Properties;
import java.util.ResourceBundle;

import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionManager;
import org.apache.ibatis.transaction.jdbc.JdbcTransactionFactory;
import org.mybatis.guice.MyBatisModule;
import org.mybatis.guice.datasource.builtin.PooledDataSourceProvider;

import com.google.inject.Guice;
import com.google.inject.Inject;
import com.google.inject.Injector;
import com.google.inject.Key;
import com.google.inject.Provider;
import com.google.inject.name.Names;


import models.domain.Person;
import models.domain.PersonDao;
import models.domain.mappers.PersonMapper;
import play.db.Database;
import play.db.NamedDatabaseImpl;
import play.mvc.*;

/**
 * This controller contains an action to handle HTTP requests
 * to the application's home page.
 */
public class HomeController extends Controller {

    /**
     * An action that renders an HTML page with a welcome message.
     * The configuration in the <code>routes</code> file means that
     * this method will be called when the application receives a
     * <code>GET</code> request with a path of <code>/</code>.
     */
	
	private PersonMapper personMapper;
	
    public Result index() {
        return ok(views.html.index.render());
    }
    
    @Inject
    public void Application(PersonMapper personMapper) {
        this.personMapper = personMapper;
    }
    
    public Result personList() {
    	Person p = new Person();
    	p.setName("张飞");
	  	  p.setAge(25);
	  	  p.setSex(0);
	  	  p.setComment("123");
	 
	  	  int ret = personMapper.append(p);
        return ok(views.html.index.render());
    }


}
