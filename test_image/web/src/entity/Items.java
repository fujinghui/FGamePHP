package entity;

//��Ʒ��
public class Items {

	private int id; // ��Ʒ���
	private String name; // ��Ʒ����
	private String city; // ����
	private String price; // �۸�
	private String picture; // ��ƷͼƬ
	private String content;

	//�����˲��������Ĺ��췽��
	public Items()
	{
		
	}
	
	public Items(int id,String name,String city,String price,String picture,String content)
	{
		this.id = id;
		this.name = name;
		this.city = city;
		this.picture = picture;
		this.price = price;
		this.content=content;
		
	}
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

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getPrice() {
		return price;
	}

	public void setPrice(String price) {
		this.price = price;
	}

	public String getPicture() {
		return picture;
	}

	public void setPicture(String picture) {
		this.picture = picture;
	}
	
	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}
	
	
	
	@Override
	public int hashCode() {
		// TODO Auto-generated method stub
		return this.getId()+this.getName().hashCode();// Ϊ������ͬ����Ʒ����������ͬ��hashcode
	}

	@Override
	public boolean equals(Object obj) {
		// TODO Auto-generated method stub
		if(this==obj)
		{
			return true;
		}
		if(obj instanceof Items) //�ж��Ƿ�����Ʒ��
		{
			Items i = (Items)obj;
			//�ж���Ʒ�ı�ź�����һ�µĻ�����Ϊ��ͬһ����Ʒ
			if(this.getId()==i.getId()&&this.getName().equals(i.getName()))
			{
				return true;
			}
			else
			{
				return false;
			}
		}
		else
		{
			return false;
		}
	}

	public String toString()
	{
		return "��Ʒ��ţ�"+this.getId()+",��Ʒ���ƣ�"+this.getName();
	}

}
