package kulijawa_client;

/**
 *
 * @author Vi
 */
public class Services {

    // <editor-fold defaultstate="collapsed" desc="User">
    private static Boolean checkEmail(java.lang.String email) {
        kulijawa_services.KulijawaWebServices_Service service = new kulijawa_services.KulijawaWebServices_Service();
        kulijawa_services.KulijawaWebServices port = service.getKulijawaWebServicesPort();
        return port.checkEmail(email);
    }

    public static String checkLogin(java.lang.String username, java.lang.String password) {
        kulijawa_services.KulijawaWebServices_Service service = new kulijawa_services.KulijawaWebServices_Service();
        kulijawa_services.KulijawaWebServices port = service.getKulijawaWebServicesPort();
        return port.checkLogin(username, password);
    }

    public static Boolean registerUser(java.lang.String fullname, java.lang.String username, java.lang.String email, java.lang.String password, java.lang.String dob) {
        kulijawa_services.KulijawaWebServices_Service service = new kulijawa_services.KulijawaWebServices_Service();
        kulijawa_services.KulijawaWebServices port = service.getKulijawaWebServicesPort();
        return port.registerUser(fullname, username, email, password, dob);
    }

    public static Boolean updateUser(java.lang.String fullname, java.lang.String username, java.lang.String email, java.lang.String password, java.lang.String role) {
        kulijawa_services.KulijawaWebServices_Service service = new kulijawa_services.KulijawaWebServices_Service();
        kulijawa_services.KulijawaWebServices port = service.getKulijawaWebServicesPort();
        return port.updateUser(fullname, username, email, password, role);
    }

    private static Boolean deleteUser(java.lang.String email) {
        kulijawa_services.KulijawaWebServices_Service service = new kulijawa_services.KulijawaWebServices_Service();
        kulijawa_services.KulijawaWebServices port = service.getKulijawaWebServicesPort();
        return port.deleteUser(email);
    }

    private static String viewUser() {
        kulijawa_services.KulijawaWebServices_Service service = new kulijawa_services.KulijawaWebServices_Service();
        kulijawa_services.KulijawaWebServices port = service.getKulijawaWebServicesPort();
        return port.viewUsers();
    }
    // </editor-fold>

    // <editor-fold defaultstate="collapsed" desc="Purchase">
    public static java.util.List<java.lang.String> viewPurchases() {
        kulijawa_services.KulijawaWebServices_Service service = new kulijawa_services.KulijawaWebServices_Service();
        kulijawa_services.KulijawaWebServices port = service.getKulijawaWebServicesPort();
        return port.viewPurchases();
    }
    // </editor-fold>

    // <editor-fold defaultstate="collapsed" desc="Notification">
    public static java.util.List<java.lang.String> viewNotifications(java.lang.String email, java.lang.String request) {
        kulijawa_services.KulijawaWebServices_Service service = new kulijawa_services.KulijawaWebServices_Service();
        kulijawa_services.KulijawaWebServices port = service.getKulijawaWebServicesPort();
        return port.viewNotifications(email, request);
    }

    public static Boolean broadcast(java.lang.String email, java.lang.String message) {
        kulijawa_services.KulijawaWebServices_Service service = new kulijawa_services.KulijawaWebServices_Service();
        kulijawa_services.KulijawaWebServices port = service.getKulijawaWebServicesPort();
        return port.broadcast(email, message);
    }
    // </editor-fold>

    // <editor-fold defaultstate="collapsed" desc="Ticket">
    // </editor-fold>
}
