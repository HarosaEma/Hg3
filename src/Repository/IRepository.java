package Repository;

public interface IRepository {
   void delete(long id);
   void update(long id) throws Exception;
   void create() throws Exception;
   void read(long id);
}
