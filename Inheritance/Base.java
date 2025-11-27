class Sub extends Base {
    @Override
    void save(Object o) { 
        if (o instanceof String) saveString((String)o);
        else defaultSave(o);
    }
    private void saveString(String s){ /*...*/ }
    private void defaultSave(Object o){ /*...*/ }
}
