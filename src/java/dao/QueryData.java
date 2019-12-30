package dao;

import java.util.*;

public class QueryData extends LinkedHashMap {
    public QueryData(){
        super();
    }

    public ArrayList<String> keys()
    {
        Set keys = this.keySet();
        ArrayList<String> result = new ArrayList(keys.size());
        Iterator iter = keys.iterator();
        while(iter.hasNext()){
            result.add((String)iter.next());
        }
        return result;
    }
}
