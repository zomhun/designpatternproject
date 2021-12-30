package dao;

import entities.Category;
import entities.Product;

public class DAOFactory {
	@SuppressWarnings({"deprecation", "rawtypes"})
	public <T> GeneralDAO getDAO(Class<T> _class){
		try {
			if(_class.newInstance() instanceof Category)
				return CategoryDAOImp.getInstance();
			if(_class.newInstance() instanceof Product)
				return ProductDAOImp.getInstance();
		} catch (InstantiationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;		
	}
}
