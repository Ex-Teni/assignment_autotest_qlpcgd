package TestScript.UserManagement.F0501_ListUserByFilter;

import java.util.List;

import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class ListUserTest extends ListUserPage{

    @BeforeTest
    @Override
    public void navigateToUserPage() {
        super.navigateToUserPage();
    }

    @Test
    public void TC01_CheckUserTypeFilter() {
        String expected = "Cơ hữu";

        selectUserType(expected);
        List<String> getUsersType = getUserTypeInList();

        for (String userType : getUsersType) {
            Assert.assertEquals(userType, expected ,"Lỗi: Có loại giảng hiện không cùng với fitler");
        }
    }

    @Test
    public void TC02_CheckUserRoleFilter() {
        String expected = "BCN khoa";

        selectUserRole(expected);
        List<String> getUsersRole = getUserRoleInList();

        for (String userRole : getUsersRole) {
            Assert.assertEquals(userRole, expected ,"Lỗi: Có vai trò giảng hiện không cùng với fitler");
        }
    }

}
