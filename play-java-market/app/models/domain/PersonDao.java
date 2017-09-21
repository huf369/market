package models.domain;

import java.util.List;

public interface PersonDao {
	 public Person getById(final int id);
	 public List getAll();
	 public int save(final Person person);
	 public int remove(final int id);
	 public void printInfo();
}
