public interface CrudCacheInterface {
    
    Object get(String str);

    void add(Object obj);

    void remove(String str);

    void update(Object obj);
}
