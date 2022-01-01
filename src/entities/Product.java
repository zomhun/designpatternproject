package entities;

import java.util.List;
import java.util.Scanner;

public class Product {
	private String id;
	private String name;
	private double price;
	private int categoryId;
	private boolean status;
	private String categoryName;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getCategoryName() {
		return categoryName;
	}
	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public int getCategoryId() {
		return categoryId;
	}
	public void setCategoryId(int categoryId) {
		this.categoryId = categoryId;
	}
	public boolean isStatus() {
		return status;
	}
	public void setStatus(boolean status) {
		this.status = status;
	}
	public void inputData(List<Product> list, List<Category> list2) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		System.out.println("Nhập vào id");
		do {
			id = sc.nextLine();
			if(id.length()==0) {
				System.out.println("Id không được để trống");
			}
			else if(this.checkId(list,id)) {
				System.out.println("Id không được trùng");
			}
			else {
				break;
			}
		} while (true);
		System.out.println("Nhập vào tên sản phẩm");
		do {
			name = sc.nextLine();
			if(name.length()==0) {
				System.out.println("Tên sản phẩm không được để trống");
			}
			else {
				break;
			}
		} while (true);
		System.out.println("Nhập vào giá sản phẩm");
		do {
			try {
				price = Double.parseDouble(sc.nextLine());
				if(price<1000) {
					System.out.println("Giá sản phẩm tối thiểu là 1000");
				}
				else {
					break;
				}
			}catch (NumberFormatException e) {
				System.out.println("Giá tiền không được để trống");
			}
		} while (true);
		System.out.println("Nhập vào mã danh mục");
		do {
			try {
				categoryId = Integer.parseInt(sc.nextLine());
				if(Category.checkId(list2,categoryId)==false) {
					System.out.println("Id danh mục không tồn tại");
				}
				else {
					break;
				}
			}catch (NumberFormatException e) {
				System.out.println("Id danh mục không được để trống");
			}
		} while (true);
		System.out.println("Nhập vào status");
		status = Boolean.parseBoolean(sc.nextLine());
	}
	public boolean checkId(List<Product> list, String id2) {
		boolean check = false;
		for (Product pro : list) {
			if(pro.getId().equals(id2)) {
				check = true;
			}
		}
		return check;
	}
	public void updateData(List list,String id2, List<Category> list2) {
		id = id2;
		Scanner sc = new Scanner(System.in);
		System.out.println("Nhập vào tên sản phẩm");
		do {
			name = sc.nextLine();
			if(name.length()==0) {
				System.out.println("Tên sản phẩm không được để trống");
			}
			else {
				break;
			}
		} while (true);
		System.out.println("Nhập vào giá sản phẩm");
		do {
			try {
				price = Double.parseDouble(sc.nextLine());
				if(price<1000) {
					System.out.println("Giá sản phẩm tối thiểu là 1000");
				}
				else {
					break;
				}
			}catch (NumberFormatException e) {
				System.out.println("Giá tiền không được để trống");
			}
		} while (true);
		System.out.println("Nhập vào mã danh mục");
		do {
			try {
				categoryId = Integer.parseInt(sc.nextLine());
				if(Category.checkId(list2,categoryId)==false) {
					System.out.println("Id danh mục không tồn tại");
				}
				else {
					break;
				}
			}catch (NumberFormatException e) {
				System.out.println("Id danh mục không được để trống");
			}
		} while (true);
		System.out.println("Nhập vào status");
		status = Boolean.parseBoolean(sc.nextLine());
	}
}
