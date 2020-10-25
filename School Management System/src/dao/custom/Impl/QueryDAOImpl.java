package dao.custom.Impl;

import dao.CrudUtil;
import dao.QueryDAO;

import java.sql.ResultSet;

public class QueryDAOImpl implements QueryDAO {
        @Override
        public String getId() throws Exception {
            ResultSet set = CrudUtil.
                    execute("SELECT reg_no FROM sregister ORDER BY reg_no DESC LIMIT 1");
            String reg_no="S001";
            if (set.next()){
                String temp=set.getString(1);
                String[] cs = temp.split("S");
                int selectedId=Integer.parseInt(cs[1]);
                if (selectedId>10){
                    reg_no="S0"+(selectedId+1);
                }
            }
            return reg_no;
        }
}
