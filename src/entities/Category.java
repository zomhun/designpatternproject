package entities;

import java.util.List;
import java.util.Scanner;


public class Category {
	private int id;
	private String name;
	private boolean status;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public boolean isStatus() {
		return status;
	}
	public void setStatus(boolean status) {
		this.status = status;
	}
	public void inputData(List<Category> list) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		System.out.println("Nhập vào id");
		do {
			id = Integer.parseInt(sc.nextLine());
			if(id==0) {
				System.out.println("Id không được để trống");
			}
			else if(this.checkId(list,id)) {
				System.out.println("Id không được trùng");
			}
			else {
				break;
			}
		} while (true);
		System.out.println("Nhập vào tên danh mục");
		do {
			name = sc.nextLine();
			if(name.length()==0) {
				System.out.println("Tên danh mục không được để trống");
			}
			else {
				break;
			}
		} while (true);
		System.out.println("Nhập vào status");
		status = Boolean.parseBoolean(sc.nextLine());
	}
	public static boolean checkId(List<Category> list, int id2) {
		boolean check = false;
		for (Category cate : list) {
			if(cate.getId()==id2) {
				check = true;
			}
		}
		return check;
	}
	public void updateData(List list,int id2) {
		id = id2;
		Scanner sc = new Scanner(System.in);
		System.out.println("Nhập vào tên danh mục");
		do {
			name = sc.nextLine();
			if(name.length()==0) {
				System.out.println("Tên danh mục không được để trống");
			}
			else {
				break;
			}
		} while (true);
		System.out.println("Nhập vào status");
		status = Boolean.parseBoolean(sc.nextLine());
	}
}
