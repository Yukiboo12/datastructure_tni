
public class TrainLinkedList {

	public static void main(String[] args) {
		LinkedList greenline = new LinkedList();
		
		greenline.insert("Mo-chit");
		
		greenline.insert("Ari");
		
		greenline.insert("Sanam-Pao");
		
		System.out.println("All Stations : " + greenline.traversal()); // แสดงสถานีทั้งหมดที่เพิ่มเข้าโป
		
		greenline.insert(2, "Rachakru"); //แทรกสถานีRachakru ระหว่างสถานี Ari กับ Sanam-Pao
		
		System.out.println("All Stations : " + greenline.traversal());
		
		System.out.println("Total Station: " + greenline.length());
		
		System.out.println("First Station: " + greenline.get(0));
		
		greenline.set(0, "Mo-Chit (Central Ladprao)"); //สถานี Mo-Chit เปลี่ยนชื่อเป็น Mo-Chit (Central Ladprao)
		
		System.out.println("All Stations : " + greenline.traversal());
		
		greenline.remove(2); //ยกเลิกสถานีRachakru
		
		System.out.println("All Stations : " + greenline.traversal());
		
		greenline.removeLastElement(); //ยกเลิกสถานีปลายทาง
		
		System.out.println("All Stations : " + greenline.traversal());
		
		greenline.clear(); // ยกเลิกสถานีรถไฟฟ้าสายสีเขียวทั้งหมด
		
		System.out.println("Total Station: " + greenline.length());
		
		System.out.println("All Stations : " + greenline.traversal());

	}

}
