package main;

import java.util.List;
import java.util.Scanner;

import dao.DAOFactory;
import dao.GeneralDAO;
import entities.Category;
import entities.Product;

public class Program {
	public static void main(String[] args) {
		DAOFactory objFactory = new DAOFactory();
		Scanner sc = new Scanner(System.in);
		theLabel:do{
			System.out.println("*****************Menu******************");
			System.out.println("1.Quản lý danh mục");
			System.out.println("2.Quản lý sản phẩm");
			System.out.println("3.Thoát");
			System.out.println("Lựa chọn của bạn:");
			try {   
			    String str = sc.nextLine();  
			    int lc=  Integer.parseInt(str);
//			int lc = Integer.parseInt(sc.nextLine());
				switch (lc) {
				case 1:
					do{
						System.out.println("*****************Quản lý danh mục******************");
						System.out.println("1.Hiển thị d/s danh mục sắp xếp theo tên A-Z (status hiển thị ẩn/hiện)");
						System.out.println("2.Thêm mới danh mục");
						System.out.println("3.Cập nhật danh mục");
						System.out.println("4.Xóa danh mục");
						System.out.println("5.Quay lại");
						System.out.println("Lựa chọn của bạn:");
						try {   
						    str = sc.nextLine();  
						    lc=  Integer.parseInt(str);
//						lc = Integer.parseInt(sc.nextLine());
							switch (lc) {
							case 1:
								GeneralDAO<Category> cateDAO = objFactory.getDAO(Category.class);
								List<Category> list = cateDAO.get();
								System.out.println("Hiển thị d/s danh mục sắp xếp theo tên A-Z");
								System.out.printf("%-15s%-50s%-5s\n","Mã danh mục","Tên danh mục","Trạng thái");
								for (Object object : list) {
									Category c = (Category) object;
									System.out.printf("%-15s%-50s%-5s\n",c.getId(),c.getName(),c.isStatus()?"Hiện":"Ẩn");
								}
								break;
							case 2:
								cateDAO = objFactory.getDAO(Category.class);
								list = cateDAO.get();
								System.out.println("Thêm mới danh mục");
								Category c = new Category();
								c.inputData(list);
								if(cateDAO.add(c)) {
									System.out.println("Thêm mới thành công");
								}else {
									System.out.println("Thêm mới thất bại");
								}
								break;
							case 3:
								cateDAO = objFactory.getDAO(Category.class);
								list = cateDAO.get();
								System.out.println("Cập nhật danh mục");
								System.out.println("Nhập vào mã danh mục muốn sửa:");
								int id = Integer.parseInt(sc.nextLine());
								c = new Category();
								if(Category.checkId(list, id)) {
									c.updateData(list,id);
									if(cateDAO.edit(c)) {
										System.out.println("Cập nhật thành công");
									}else {
										System.out.println("Cập nhật thất bại");
									}
								}else {
									System.out.println("Không tìm thấy id");
								}
								break;
							case 4:
								cateDAO = objFactory.getDAO(Category.class);
								list = cateDAO.get();
								System.out.println("Xóa danh mục");
								System.out.println("Nhập vào mã danh mục muốn xóa:");
								id = Integer.parseInt(sc.nextLine());
								c = new Category();
								if(Category.checkId(list, id)) {
									System.out.println("Bạn có chắc chắn muốn xóa không?(y/n)");
									String xn = sc.nextLine();
									if(xn.equalsIgnoreCase("y")) {
										c.setId(id);
										if(cateDAO.remove(c)) {
											System.out.println("Xóa thành công");
										}else {
											System.out.println("Xóa thất bại");
										}
									}else {
										System.out.println("Xóa thất bại");
									}
								}else {
									System.out.println("Không tìm thấy id");
								}
								break;
							case 5:
								continue theLabel;
							default:
								System.out.println("Nhập từ 1 đến 5");
								break;
							}
						}catch(Exception e) {  
						     System.out.println("Vui lòng nhập số");               
						    }
					}while(true);
				case 2:
					do{
						System.out.println("*****************Quản lý sản phẩm******************");
						System.out.println("1.Hiển thị d/s sản phẩm (id, name, price, categoryName, status(ẩn/hiện))");
						System.out.println("2.Thêm mới sản phẩm");
						System.out.println("3.Cập nhật thông tin sản phẩm");
						System.out.println("4.Xóa sản phẩm");
						System.out.println("5.Quay lại");
						System.out.println("Lựa chọn của bạn:");
						try {   
						    str = sc.nextLine();  
						    lc=  Integer.parseInt(str);
//						lc = Integer.parseInt(sc.nextLine());
							switch (lc) {
							case 1:
								GeneralDAO<Product> proDAO = objFactory.getDAO(Product.class);
								List<Product> list = proDAO.get();
								System.out.println("Hiển thị d/s sản phẩm");
								System.out.printf("%-15s%-50s%-20s%-50s%-5s\n","Mã sản phẩm","Tên sản phẩm","giá","Tên danh mục","Trạng thái");
								for (Object object : list) {
									Product p = (Product) object;
									System.out.printf("%-15s%-50s%-20.0f%-50s%-5s\n",p.getId(),p.getName(),p.getPrice(),p.getCategoryName(),p.isStatus()?"Hiện":"Ẩn");
								}
								break;
							case 2:
								GeneralDAO<Category> cateDAO = objFactory.getDAO(Category.class);
								List<Category> list2 = cateDAO.get();
								proDAO = objFactory.getDAO(Product.class);
								list = proDAO.get();
								System.out.println("Thêm mới danh mục");
								Product p = new Product();
								p.inputData(list,list2);
								if(proDAO.add(p)) {
									System.out.println("Thêm mới thành công");
								}else {
									System.out.println("Thêm mới thất bại");
								}
								break;
							case 3:
								cateDAO = objFactory.getDAO(Category.class);
								list2 = cateDAO.get();
								proDAO = objFactory.getDAO(Product.class);
								list = proDAO.get();
								System.out.println("Cập nhật sản phẩm");
								System.out.println("Nhập vào mã sản phẩm muốn sửa:");
								String id = sc.nextLine();
								p = new Product();
								if(p.checkId(list, id)) {
									p.updateData(list,id,list2);
									if(proDAO.edit(p)) {
										System.out.println("Cập nhật thành công");
									}else {
										System.out.println("Cập nhật thất bại");
									}
								}else {
									System.out.println("Không tìm thấy id");
								}
								break;
							case 4:
								proDAO = objFactory.getDAO(Product.class);
								list = proDAO.get();
								System.out.println("Xóa sản phẩm");
								System.out.println("Nhập vào mã sản phẩm muốn xóa:");
								id = sc.nextLine();
								p = new Product();
								if(p.checkId(list, id)) {
									p.setId(id);
									if(proDAO.remove(p)) {
										System.out.println("Xóa thành công");
									}else {
										System.out.println("Xóa thất bại");
									}
								}else {
									System.out.println("Không tìm thấy id");
								}
								break;
							case 5:
								continue theLabel;
							default:
								System.out.println("Nhập từ 1 đến 5");
								break;
							}
							}catch(Exception e) {  
							     System.out.println("Vui lòng nhập số");               
							    }
					}while(true);
				case 3:
					System.exit(0);
				default:
					System.out.println("Vui lòng nhập lại");
					break;
				}
			}  
		    catch(Exception e) {  
		     System.out.println("Vui lòng nhập số");               
		    }
		}while(true);
	}
}
