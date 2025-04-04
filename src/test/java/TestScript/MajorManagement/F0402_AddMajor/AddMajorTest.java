package TestScript.MajorManagement.F0402_AddMajor;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.fasterxml.jackson.databind.JsonNode;

import TestScript.MajorManagement.MajorElement;
import helpers.JsonReader;

public class AddMajorTest extends AddMajorPage {

  private static final String FILE_NAME = "major/add_major_test_data.json";

  @BeforeTest
  @Override
  public void navigateToMajorPage() {
    super.navigateToMajorPage();
  }

  @Test
  // TC01: Thêm ngành học mới với dữ liệu hợp lệ
  public void TC01_ValidAddMajor() {
    // Đọc dữ liệu truyền vào
    JsonNode data = JsonReader.getTestData(FILE_NAME, "TC01");
    String id = data.get("id").asText();
    String name = data.get("name").asText();
    String abbrev = data.get("abbrev").asText();
    String program = data.get("program").asText();

    // Thêm ngành học mới
    performAddMajor(id, name, abbrev, program);
    delay(1000);
    
    System.out.println(">>Output context TC01 (ValidAddMajor): ");
    getCellByMajorID(id);

    // Refresh trang
    driver.navigate().refresh();
    delay(300);
    
  }

  @Test
  // TC02: Trùng ID ngành
  public void TC02_IDFailed() {
    // Dữ liệu truyền vào
    JsonNode data = JsonReader.getTestData(FILE_NAME, "TC02");
    String id = data.get("id").asText();
    String name = data.get("name").asText();
    String abbrev = data.get("abbrev").asText();
    String program = data.get("program").asText();

    // Thêm ngành học mới
    performAddMajor(id, name, abbrev, program);
    delay(300);

    // Lấy thông báo >>Output context
    String actualMessage = getPopupErrorMessage();
    System.out.println(">>Output context TC02 (IDFailed): " + actualMessage);
    delay(300);
    getCellByMajorID(id);

    // Refresh trang
    driver.navigate().refresh();
    delay(300);
  }

  @Test
  // TC03: ID ngành là chữ có dấu
  public void TC03_IDAsText() {
    // Dữ liệu truyền vào
    JsonNode data = JsonReader.getTestData(FILE_NAME, "TC03");
    String id = data.get("id").asText();
    String name = data.get("name").asText();
    String abbrev = data.get("abbrev").asText();
    String program = data.get("program").asText();

    // Thêm ngành học mới
    performAddMajor(id, name, abbrev, program);
    delay(300);

    // Lấy thông báo lỗi
    String actualMessage = getFormErrorMessage(MajorElement.MAJOR_ID_FIELD_ERROR);
    System.out.println(">>Output context TC03 (IDasText): " + actualMessage);
    delay(300);
    getCellByMajorID(id);

    // Refresh trang
    driver.navigate().refresh();
    delay(300);
  }

  @Test
  // TC04: ID ngành có khoảng trắng
  public void TC04_IDGotBlank() {
    // Dữ liệu truyền vào
    JsonNode data = JsonReader.getTestData(FILE_NAME, "TC04");
    String id = data.get("id").asText();
    String name = data.get("name").asText();
    String abbrev = data.get("abbrev").asText();
    String program = data.get("program").asText();

    // Thêm ngành học mới
    performAddMajor(id, name, abbrev, program);
    delay(300);

    // Lấy thông báo lỗi
    String actualMessage = getFormErrorMessage(MajorElement.MAJOR_ID_FIELD_ERROR);
    System.out.println(">>Output context TC04 (IDGotBlank): " + actualMessage);
    delay(300);
    getCellByMajorID(id);

    // Refresh trang
    driver.navigate().refresh();
    delay(300);
  }

  @Test
  // TC05: ID ngành bỏ trống
  public void TC05_IDBlank() {
    // Dữ liệu truyền vào
    JsonNode data = JsonReader.getTestData(FILE_NAME, "TC05");
    String id = data.get("id").asText();
    String name = data.get("name").asText();
    String abbrev = data.get("abbrev").asText();
    String program = data.get("program").asText();

    // Thêm ngành học mới
    performAddMajor(id, name, abbrev, program);
    delay(300);

    // Lấy thông báo lỗi
    String actualMessage = getFormErrorMessage(MajorElement.MAJOR_ID_FIELD_ERROR);
    System.out.println(">>Output context TC05 (IDBlank): " + actualMessage);
    delay(300);
    getCellByMajorID(id);

    // Refresh trang
    driver.navigate().refresh();
    delay(300);
  }

  @Test
  // TC06: Tên ngành bỏ trống
  public void TC06_NameBlank() {
    // Dữ liệu truyền vào
    JsonNode data = JsonReader.getTestData(FILE_NAME, "TC06");
    String id = data.get("id").asText();
    String name = data.get("name").asText();
    String abbrev = data.get("abbrev").asText();
    String program = data.get("program").asText();

    // Thêm ngành học mới
    performAddMajor(id, name, abbrev, program);
    delay(300);

    // Lấy thông báo lỗi
    String actualMessage = getFormErrorMessage(MajorElement.MAJOR_NAME_FIELD_ERROR);
    System.out.println(">>Output context TC06 (NameBlank): " + actualMessage);
    delay(300);
    getCellByMajorID(id);

    // Refresh trang
    driver.navigate().refresh();
    delay(300);
  }

  @Test
  // TC07: Tên ngành viết tắt để trống
  public void TC07_NameShortBlank() {
    // Dữ liệu truyền vào
    JsonNode data = JsonReader.getTestData(FILE_NAME, "TC07");
    String id = data.get("id").asText();
    String name = data.get("name").asText();
    String abbrev = data.get("abbrev").asText();
    String program = data.get("program").asText();

    // Thêm ngành học mới
    performAddMajor(id, name, abbrev, program);
    delay(300);

    // Lấy thông báo lỗi
    String actualMessage = getFormErrorMessage(MajorElement.MAJOR_ABBREV_FIELD_ERROR);
    System.out.println(">>Output context TC07 (AbbBlank): " + actualMessage);
    delay(300);
    getCellByMajorID(id);

    // Refresh trang
    driver.navigate().refresh();
    delay(300);
  }
}