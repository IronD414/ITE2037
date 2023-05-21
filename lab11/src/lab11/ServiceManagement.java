package lab11;

import java.util.ArrayList;
import java.lang.reflect.*;

public class ServiceManagement {
	public static<T extends Hub> int findIndexByNum(ArrayList<T> tList, int num)
	{
	//택배박스번호로찾기
	//찾으면해당인덱스반환,찾지못하면-1반환
		for (int i = 0; i < tList.size(); i++) 
		{
			if (tList.get(i).getNumber() == num) {return i;}
		}
		return -1;
	}
	public static<T extends Hub> T raisePerBox(T t, double rate)
	{
	//택배박스개당요금변경,e.g.1.05==5%상승
		t.setPrice_per_box(rate * t.getPrice_per_box());
		return t;
	}
	public static <T extends Hub> ArrayList<T> raiseAll(Class<T> c, ArrayList<T> tList, double rate) 
	{
		//tList의모든박스요금변경,e.g.1.05==5%상승
		for(T elem : tList) 
		{
		//아래메소드는자신이정한메소드이름에맞게변경
			elem.setPrice_per_box(rate * elem.getPrice_per_box());
		}
		//해당지역허브의기본택배요금변경
		try 
		{
			Field f = c.getField("init_price_per_box");
			double value = f.getDouble(null);
			f.setDouble(null, value * rate); // no need to be an object, because it is static variable.
		} 
		catch (NoSuchFieldException | SecurityException | IllegalArgumentException | IllegalAccessException e) 
		{
			e.printStackTrace();
		}
		return tList;
	}
	@SuppressWarnings("unchecked")
	public static<T extends Hub> void packageBoxes(String[] descriptions, Class<T> classtype, ArrayList<T> tList)
	{
		/*
		*1.descriptions배열의 모든 항목을 각 Hub별 인스턴스 생성자를 이용해 캡슐화한다.
		*2.이때, 인자로 받은 classtype 매개변수로 getConstructor, newInstance 메소드를 호출할 수 있다.
		*3.tList에는 해당 Hub타입을 가진 인스턴스만 담는다.
		*4.try/catch를 사용해, 위 메소드를 이용하기 위해 필요한 exception처리를 수행한다.
		*/
		try
		{
			Class<?> cls = classtype;
			Constructor<?> constructor = cls.getConstructor(String.class);
			for (String elem : descriptions)
			{
				tList.add((T) constructor.newInstance(elem));
			}
		}
		catch(Exception e)
		{
			// ???
		}
	}
	public static <T extends Hub, U extends Hub> void changeHub(ArrayList<T> tList, int index, Class<U> classtype, ArrayList<U> uList) 
	{
		try 
		{
			// tList에서 index를 통해 객체를 하나 가져온다.
			T x = tList.get(index);
			// getDescription 메소드를 이용해 description 정보를 가져온다.
			String d = x.getDescription();
			// 해당 정보를 이용해 U classtype으로 새로운 객체를 생성한다.
			U y = (U) classtype.getConstructor(String.class).newInstance(d);
			// tList에서 원래 객체를 null로 세팅한다.
			tList.set(index, null);
			// 새로 만든 객체는 지연 배송에 따른 할인으로 -10%를 적용한다. (0.9)
			ServiceManagement.raisePerBox(y, 0.9);
			// uList에 새로 만든 객체를 추가한다.
			uList.add(y);
		} catch (InstantiationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalArgumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (NoSuchMethodException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SecurityException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
