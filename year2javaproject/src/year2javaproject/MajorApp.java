
package year2javaproject;

import java.util.ArrayList; // เก็บข้อมูลที่เพิ้มข้อมูลได้
import java.util.Scanner; // รับข้อมูลจากผู้ใช้

public class MajorApp {

    // สร้าง Array 1 มิติ เก็บข้อมูลคงที่
    static String[] movies = {"Resident Evil", "Harry Potter", "Spider Man"}; // เพื่อเก็บชื่อภาพยนตร์ทั้งหมด 3 เรื่อง
    static String[] dates = {"15 ต.ค.", "16 ต.ค.", "17 ต.ค."}; // เพื่อเก็บวันที่ให้ผู้ใช้เลือก
    static String[] times = {"11:00", "14:30", "19:00"}; // เพื่อเก็บรอบเวลาฉายภาพยนตร์    
    
    // สร้าง Array 2 มิติ จำลองผังที่นั่ง [i]5 แถว / [j]4 คอลัมน์
    static int[][] seats = new int[5][4];

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in); // สร้าง Scanner ชื่อ scanner เพื่อรับข้อมูลจากคีย์บอร์ด
        
        // สร้าง ArrayList ไว้เก็บข้อมูลที่ไม่รู้จำนวนล่วงหน้า
        ArrayList<String> bookedSeats = new ArrayList<String>(); // สำหรับเก็บรายละเอียดที่นั่งที่ผู้ใช้จอง
        ArrayList<String> snackCart = new ArrayList<String>(); // สำหรับเก็บรายการอาหารและเครื่องดื่มที่ผู้ใช้เลือก
        int totalPrice = 0; // เพื่อเก็บยอดเงินรวม โดยเริ่มต้นที่ 0 บาท
        
        System.out.println("==================================");
        System.out.println("  ยินดีต้อนรับสู่ Major Cineplex  ");
        System.out.println("==================================");

        
        
            // ----- ขั้นตอนที่ 1: เลือกหนัง -----
            System.out.println("\n[1] เลือกภาพยนตร์");
            for (int i = 0; i < movies.length; i++) { // ใช้ for loop วนซ้ำเพื่อแสดงภาพยนตร์ทุกเรื่อง
                System.out.println((i + 1) + ". " + movies[i]); // แสดง หมายเลขรายการและชื่อภาพยนตร์แต่ละเรื่อง
            }
            System.out.print("เลือกภาพยนตร์ (1-3): ");
            int movieChoice = scanner.nextInt() - 1;  // รับหมายเลขภาพยนตร์จากผู้ใช้แล้วลบ 1 เพื่อเปลี่ยนเป็น Index ของ Array
            String selectedMovie = movies[movieChoice]; // นำ Index ที่เลือกไปดึงชื่อภาพยนตร์จาก Array movies
            
            // ----- ขั้นตอนที่ 2: เลือกวันที่และรอบฉาย -----
            System.out.println("\n[2] เลือกวันที่และรอบฉาย");
            for (int i = 0; i < dates.length; i++) { // ใช้ for loop วนซ้ำเพื่อแสดงวันที่ทั้งหมด
                System.out.println((i + 1) + ". " + dates[i]);//บวกหนึ่งเพื่อเวลาแสดงผลเริ่มที่เลขหนึ่ง
            }
            System.out.print("เลือกวันที่ (1-3): ");
            String selectedDate = dates[scanner.nextInt() - 1];//รับค่าและเก็บค่าไปไว้ในselectedDate

            
            for (int i = 0; i < times.length; i++) {  // ใช้ for loop วนซ้ำเพื่อ แสดงรอบเวลาฉายทั้งหมด
                System.out.println((i + 1) + ". " + times[i]);
            }
            System.out.print("เลือกรอบฉาย (1-3): ");
            String selectedTime = times[scanner.nextInt() - 1];

            
            
            // ----- ขั้นตอนที่ 3: เลือกที่นั่ง -----
            boolean selectingSeat = true;  // true หมายถึงยังอยู่ในขั้นตอนเลือกที่นั่ง
            while (selectingSeat) { // ใช้ while loop ทำซ้ำตราบใดที่ิบูลีนเป็นค่าจริง
            	
                System.out.println("\n[3] เลือกที่นั่ง");
                System.out.println("แถว 1-2 : ที่นั่งพิเศษ ราคา 350 บาท");
                System.out.println("แถว 3-5 : ที่นั่งปกติ ราคา 250 บาท");
                System.out.println("----------------------------------");
                
                // สร้าง ผังที่นัง
                System.out.println("      A   B   C   D");
                // วนลูป 2 ชั้น (Nested Loop) เพื่อแสดง 2D Array
                for (int i = 0; i < seats.length; i++) { // วนลูปแสดงผังที่นั่งทีละแถว โดย i คือหมายเลขแถว
                    System.out.print("แถว " + (i+1) + " "); //บวกเพื่อกำหนดว่าให้แถวเริ่มที่เลขหนึ่ง  / (i+1)คือ(1,2,3,4,5)
                    for (int j = 0; j < seats[i].length; j++) { //checkเงื่อนไข ของA,B,C,Dคอลัมน์
                        // ใช้ if-else ธรรมดาตรวจสอบที่นั่งว่าง
                        if (seats[i][j] == 0) {  //iคือ แถวแนวนอน ส่วนjคือ คอลัมแนวตั้ง
                            System.out.print("[ ] ");
                        } else {
                            System.out.print("[X] ");
                        }
                    }
                    System.out.println();
                }
                // รับข้อมูลจาก สร้าง ผังที่นัง
                System.out.println("----------------------------------");

                System.out.print("ระบุแถว (1-5): ");
                int row = scanner.nextInt() -1; //เปลียนกับเป็นindex(0,1,2,3,4)
                
                System.out.print("ระบุที่นั่ง (A-D): ");
                char colChar = scanner.next().toUpperCase().charAt(0);  //colคือการรอข้อมูลเข้า
                int col = -1; //-1คือ ยังไม่ได้เก็บข้อมูล ถ้าเก็บข้อมูลคือ เริ่มที่0 ให้
                if (colChar == 'A') {
                    col = 0;
                } else if (colChar == 'B') {
                    col = 1;
                } else if (colChar == 'C') {
                    col = 2;
                } else if (colChar == 'D') {
                    col = 3;
                }

                // ใช้ if-else ซ้อนกัน (ifซ่อนif) ตรวจสอบเงื่อนไข ที่นังว่างไม?
                if (row >= 0 && row < 5 && col >= 0 && col < 4) { //checkเพื่อดูว่า แถว กับ คอลัมน์ อยู่ในขแบเขตที่กำหนดมั้ย ถ้าอยู่จะเข้าเงื่อนไขต่อไป คือ เช็คที่นั่งว่าง
                    if (seats[row][col] == 0) { //ยังไม่มีคนนั่ง และ ตรวจสอบประเภทที่นั่งตามแถวและคอลั่มที่เลือกไว้
                        seats[row][col] = 1; //มีคนจองที่นั่งแล้ว จะข้ามขั้นตอนการเช็คราคาไป และแสดงข้อความ ขออภัย ที่นั่งนี้มีคนจองแล้วค่ะ
                        
                        String seatType;//เช็คประเภทที่นั่งเพื่อกำหนดราคา
                        int price;//ตัวแปรเก็บราคา
                        if (row <= 1) { //index 0-1 คือแถวที่ 1-2
                            seatType = "พิเศษ";
                            price = 350;
                        } else {//นอกจากนั้นคือราคาปกติ คือ แถวที่ 3-5
                            seatType = "ปกติ";
                            price = 250;
                        }
                        
                        totalPrice += price;//นำราคามาบวกกับยอดเดิม กรณีจองหลายที่นั่ง
                        bookedSeats.add("แถว " + (row+1) + " ที่นั่ง " + colChar + " (" + seatType + ")"); // นำข้อมูลที่ได้มาจากการจองมาสรุปใน bookedSeats ของอาเรย์ลิส
                        System.out.println(">> จองที่นั่งสำเร็จ!");
                    } else {
                        System.out.println(">> ขออภัย ที่นั่งนี้มีคนจองแล้วค่ะ"); // มีคนนั่ง หรือ ที่นังซ้ำกัน
                    }
                } else {
                    System.out.println(">> กรอกตำแหน่งแถวหรือที่นั่งไม่ถูกต้องค่ะ (A-D เท่านั้น)"); // กรณีที่ผู้ใช้กรอกนอกเหนือจากA-D
                }
                System.out.print("\nต้องการจองที่นั่งเพิ่มหรือไม่? (1=จองเพิ่ม, 0=พอแล้วไปหน้าต่อไป): ");//ถ้าเลือก 1 จะคือการวนกลับไปทำงานในลูปเพื่อเลือกที่นั่งเพิ่ม  
                if (scanner.nextInt() == 0) {//ถ้าเป็น 0 จะออกจากลูปละไปขั้นตอนต่อไป
                    selectingSeat = false; 
                }
            }

            
            
            // ----- ขั้นตอนที่ 4: เลือกอาหารว่าง -----
            boolean selectingSnack = true; //กำลังเลือกอาหาร ใช้ boolean เพื่อเป็นตัวเลือกว่าจะสั่งอาหารหรือไม่สั่ง
            while (selectingSnack) {// เข้า ลูป while กรณีที่ลูกค้าต้องการสั่งอาหารหลายรายการ
            	System.out.println("\n[4] อาหารว่างและเครื่องดื่ม");//แสดงรายการ
            	System.out.println("0. ไม่ต้องการ / ข้ามไปหน้าชำระเงิน");
                System.out.println("1. ป๊อปคอร์น Size S (50 บาท)");
                System.out.println("2. ป๊อปคอร์น Size M (100 บาท)");
                System.out.println("3. น้ำดื่ม Size S (50 บาท)");
                System.out.println("4. น้ำดื่ม Size M (100 บาท)");
                System.out.print("เลือกรายการ (0-4): ");
                int snackChoice = scanner.nextInt();//รับค่าที่ลูกค้าเลือกเข้ามาเก็บในsnackChoice เป็นตัวเลข 0-4

                // ใช้ if..else if..else
                if (snackChoice == 0) {
                    selectingSnack = false;//กรณีเป็น 0 ไม่สั่งอาหารจะข้ามไปชำระเงินเลยออกจากลูป
                 //กรณีสั่งอาหารรายการ 1-4 เอาค่าที่รับที่เป็นตัวเลข เข้ามาเปรียบเทียบกับประเภทอาหาร 
                } else if (snackChoice == 1) {
                    snackCart.add("ป๊อปคอร์น S"); 
                    totalPrice += 50;
                    System.out.println(">> เพิ่ม ป๊อปคอร์น S ลงตะกร้า");
                } else if (snackChoice == 2) {
                    snackCart.add("ป๊อปคอร์น M"); 
                    totalPrice += 100;
                    System.out.println(">> เพิ่ม ป๊อปคอร์น M ลงตะกร้า");
                } else if (snackChoice == 3) {
                    snackCart.add("น้ำดื่ม S"); 
                    totalPrice += 50;
                    System.out.println(">> เพิ่ม น้ำดื่ม S ลงตะกร้า");
                } else if (snackChoice == 4) {
                    snackCart.add("น้ำดื่ม M"); 
                    totalPrice += 100;
                    System.out.println(">> เพิ่ม น้ำดื่ม M ลงตะกร้า");
                } else {
                    System.out.println(">> ตัวเลือกไม่ถูกต้องค่ะ");//กรณีใส่ตัวเลขนอกเหนือจากรายการทั้งหมด 0-4 จะขึ้นให้ใส่ข้อมูลใหม่
                }
            }

            
            
            // ----- ขั้นตอนที่ 5: หน้าสรุปยอด -----
            System.out.println("\n==================================");
            System.out.println("          สรุปยอดสั่งซื้อ          ");
            System.out.println("==================================");
            System.out.println("ภาพยนตร์: " + selectedMovie);//นำหนังที่เลือกจากขั้นตอนที่ 1 มาแสดงผล
            System.out.println("วันที่และรอบฉาย: " + selectedDate + " เวลา " + selectedTime);//นำวันที่และรอบฉายที่เลือกจากขั้นตอนที่ 2 มาแสดงผล
            
            System.out.println("\nจำนวนที่นั่ง: " + bookedSeats.size() + " ที่นั่ง"); // ใช้ .size() นับจำนวนรายการที่มีทั้งหมด //นำจำนวนที่นั่งที่เลือกจากขั้นตอนที่ 3 มาแสดงผล
            for (int i = 0; i < bookedSeats.size(); i++) {//วนเพื่อนับที่นั่งทั้งหมดของ bookedSeats ที่เก็บไว้ใน ArrayList
                System.out.println(" - " + bookedSeats.get(i)); // ใช้ .get() ดึงข้อมูลที่นั่งทั้งหมดของ bookedSeats ออกมาแสดง
            }
            
            if (snackCart.size() > 0) {//เช็คว่าได้สั่งขนมหรือไม่
                System.out.println("\nชุดอาหารทานเล่น:");
                for (int i = 0; i < snackCart.size(); i++) {//กรณีสั่ง ใช้ forเพื่อวนนับขนมทั้งหมดที่เก็บไว้ใน snackCart
                    System.out.println(" - " + snackCart.get(i));// ใช้ .get() ดึงข้อมูลที่นั่งทั้งหมดของ snackCart ออกมาแสดง
                }
            } else {
                System.out.println("\nชุดอาหารทานเล่น: - (ไม่มี)");//กรณีไม่ได้สั่ง
            }
            
            System.out.println("\n>> ยอดรวมทั้งหมด: " + totalPrice + " บาท <<");
            System.out.println("==================================");

            
            
            // ----- ขั้นตอนที่ 6: หน้าชำระเงิน -----
            boolean paymentProcess = true;//กรณีที่ได้ข้อมูลตรงกับเงื่อนไขให้เข้าไปในลูปเพื่อทำงานต่อ 
            while (paymentProcess) {
                System.out.println("\n[6] เลือกช่องทางการชำระเงิน");
                System.out.println("1. QR Code");
                System.out.println("2. TrueMoney Wallet");
                System.out.print("เลือกช่องทาง (1-2): ");
                int payMethod = scanner.nextInt();//รับค่าจากผู้ใช้เข้ามา
                
                //  ใช้ if-else ธรรมดาตรวจสอบช่องทางจ่ายเงิน
                String Payment;//สร้างตัวแปรเก็บช่องทางการจ่ายเงิน
                if (payMethod == 1) {
                	Payment = "QR Code";
                } else if (payMethod == 2){
                	Payment = "TrueMoney Wallet";
                }else {
                	System.out.println("เลือกไม่ถูกต้อง กรุณาเลือก 1 หรือ 2 เท่านั้น");
                	continue;
                }
                
                System.out.println("\nระบบกำลังสร้างรายการชำระเงินผ่าน " + Payment + " จำนวน " + totalPrice + " บาท...");

                System.out.println("\nกรุณายืนยันการชำระเงิน");
                System.out.println("1. ยืนยันการชำระเงินเรียบร้อยแล้ว");
                System.out.println("2. ลองใหม่อีกครั้ง (กลับไปเลือกช่องทางจ่ายเงิน)");
                System.out.println("3. ยกเลิกรายการจองทั้งหมด");
                System.out.print("เลือก (1-3): ");
                int confirm = scanner.nextInt();//รับค่าจากผู้ใช้ที่เลือกขั้นการยืนยันการชำระเงิน

                if (confirm == 1) {
                    System.out.println("\n**********************************");
                    System.out.println("  ขอบคุณที่ใช้บริการ ขอให้สนุกกับภาพยนตร์ค่ะ!  ");
                    System.out.println("**********************************");
                    paymentProcess = false;
                } else if (confirm == 2) {
                    System.out.println("\n>> วนกลับไปเลือกช่องทางการชำระเงินใหม่...");
                } else if (confirm == 3) {
                    System.out.println("\n>> ยกเลิกรายการเรียบร้อยแล้ว หวังว่าจะได้ให้บริการในครั้งหน้านะคะ");
                    paymentProcess = false;
                } else {
                    System.out.println("\n>> ตัวเลือกไม่ถูกต้อง กรุณาทำรายการใหม่ค่ะ");
                }
            }            
    }
}
