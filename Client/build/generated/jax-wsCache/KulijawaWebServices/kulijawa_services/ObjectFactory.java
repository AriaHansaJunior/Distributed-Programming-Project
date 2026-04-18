
package kulijawa_services;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the kulijawa_services package. 
 * <p>An ObjectFactory allows you to programatically 
 * construct new instances of the Java representation 
 * for XML content. The Java representation of XML 
 * content can consist of schema derived interfaces 
 * and classes representing the binding of schema 
 * type definitions, element declarations and model 
 * groups.  Factory methods for each of these are 
 * provided in this class.
 * 
 */
@XmlRegistry
public class ObjectFactory {

    private final static QName _Broadcast_QNAME = new QName("http://services.kulijawa.com/", "broadcast");
    private final static QName _BroadcastResponse_QNAME = new QName("http://services.kulijawa.com/", "broadcastResponse");
    private final static QName _CheckEmail_QNAME = new QName("http://services.kulijawa.com/", "checkEmail");
    private final static QName _CheckEmailResponse_QNAME = new QName("http://services.kulijawa.com/", "checkEmailResponse");
    private final static QName _CheckLogin_QNAME = new QName("http://services.kulijawa.com/", "checkLogin");
    private final static QName _CheckLoginResponse_QNAME = new QName("http://services.kulijawa.com/", "checkLoginResponse");
    private final static QName _DeleteUser_QNAME = new QName("http://services.kulijawa.com/", "deleteUser");
    private final static QName _DeleteUserResponse_QNAME = new QName("http://services.kulijawa.com/", "deleteUserResponse");
    private final static QName _RegisterUser_QNAME = new QName("http://services.kulijawa.com/", "registerUser");
    private final static QName _RegisterUserResponse_QNAME = new QName("http://services.kulijawa.com/", "registerUserResponse");
    private final static QName _UpdateUser_QNAME = new QName("http://services.kulijawa.com/", "updateUser");
    private final static QName _UpdateUserResponse_QNAME = new QName("http://services.kulijawa.com/", "updateUserResponse");
    private final static QName _ViewNotifications_QNAME = new QName("http://services.kulijawa.com/", "viewNotifications");
    private final static QName _ViewNotificationsResponse_QNAME = new QName("http://services.kulijawa.com/", "viewNotificationsResponse");
    private final static QName _ViewPurchases_QNAME = new QName("http://services.kulijawa.com/", "viewPurchases");
    private final static QName _ViewPurchasesResponse_QNAME = new QName("http://services.kulijawa.com/", "viewPurchasesResponse");
    private final static QName _ViewUsers_QNAME = new QName("http://services.kulijawa.com/", "viewUsers");
    private final static QName _ViewUsersResponse_QNAME = new QName("http://services.kulijawa.com/", "viewUsersResponse");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: kulijawa_services
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link Broadcast }
     * 
     */
    public Broadcast createBroadcast() {
        return new Broadcast();
    }

    /**
     * Create an instance of {@link BroadcastResponse }
     * 
     */
    public BroadcastResponse createBroadcastResponse() {
        return new BroadcastResponse();
    }

    /**
     * Create an instance of {@link CheckEmail }
     * 
     */
    public CheckEmail createCheckEmail() {
        return new CheckEmail();
    }

    /**
     * Create an instance of {@link CheckEmailResponse }
     * 
     */
    public CheckEmailResponse createCheckEmailResponse() {
        return new CheckEmailResponse();
    }

    /**
     * Create an instance of {@link CheckLogin }
     * 
     */
    public CheckLogin createCheckLogin() {
        return new CheckLogin();
    }

    /**
     * Create an instance of {@link CheckLoginResponse }
     * 
     */
    public CheckLoginResponse createCheckLoginResponse() {
        return new CheckLoginResponse();
    }

    /**
     * Create an instance of {@link DeleteUser }
     * 
     */
    public DeleteUser createDeleteUser() {
        return new DeleteUser();
    }

    /**
     * Create an instance of {@link DeleteUserResponse }
     * 
     */
    public DeleteUserResponse createDeleteUserResponse() {
        return new DeleteUserResponse();
    }

    /**
     * Create an instance of {@link RegisterUser }
     * 
     */
    public RegisterUser createRegisterUser() {
        return new RegisterUser();
    }

    /**
     * Create an instance of {@link RegisterUserResponse }
     * 
     */
    public RegisterUserResponse createRegisterUserResponse() {
        return new RegisterUserResponse();
    }

    /**
     * Create an instance of {@link UpdateUser }
     * 
     */
    public UpdateUser createUpdateUser() {
        return new UpdateUser();
    }

    /**
     * Create an instance of {@link UpdateUserResponse }
     * 
     */
    public UpdateUserResponse createUpdateUserResponse() {
        return new UpdateUserResponse();
    }

    /**
     * Create an instance of {@link ViewNotifications }
     * 
     */
    public ViewNotifications createViewNotifications() {
        return new ViewNotifications();
    }

    /**
     * Create an instance of {@link ViewNotificationsResponse }
     * 
     */
    public ViewNotificationsResponse createViewNotificationsResponse() {
        return new ViewNotificationsResponse();
    }

    /**
     * Create an instance of {@link ViewPurchases }
     * 
     */
    public ViewPurchases createViewPurchases() {
        return new ViewPurchases();
    }

    /**
     * Create an instance of {@link ViewPurchasesResponse }
     * 
     */
    public ViewPurchasesResponse createViewPurchasesResponse() {
        return new ViewPurchasesResponse();
    }

    /**
     * Create an instance of {@link ViewUsers }
     * 
     */
    public ViewUsers createViewUsers() {
        return new ViewUsers();
    }

    /**
     * Create an instance of {@link ViewUsersResponse }
     * 
     */
    public ViewUsersResponse createViewUsersResponse() {
        return new ViewUsersResponse();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Broadcast }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link Broadcast }{@code >}
     */
    @XmlElementDecl(namespace = "http://services.kulijawa.com/", name = "broadcast")
    public JAXBElement<Broadcast> createBroadcast(Broadcast value) {
        return new JAXBElement<Broadcast>(_Broadcast_QNAME, Broadcast.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link BroadcastResponse }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link BroadcastResponse }{@code >}
     */
    @XmlElementDecl(namespace = "http://services.kulijawa.com/", name = "broadcastResponse")
    public JAXBElement<BroadcastResponse> createBroadcastResponse(BroadcastResponse value) {
        return new JAXBElement<BroadcastResponse>(_BroadcastResponse_QNAME, BroadcastResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link CheckEmail }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link CheckEmail }{@code >}
     */
    @XmlElementDecl(namespace = "http://services.kulijawa.com/", name = "checkEmail")
    public JAXBElement<CheckEmail> createCheckEmail(CheckEmail value) {
        return new JAXBElement<CheckEmail>(_CheckEmail_QNAME, CheckEmail.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link CheckEmailResponse }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link CheckEmailResponse }{@code >}
     */
    @XmlElementDecl(namespace = "http://services.kulijawa.com/", name = "checkEmailResponse")
    public JAXBElement<CheckEmailResponse> createCheckEmailResponse(CheckEmailResponse value) {
        return new JAXBElement<CheckEmailResponse>(_CheckEmailResponse_QNAME, CheckEmailResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link CheckLogin }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link CheckLogin }{@code >}
     */
    @XmlElementDecl(namespace = "http://services.kulijawa.com/", name = "checkLogin")
    public JAXBElement<CheckLogin> createCheckLogin(CheckLogin value) {
        return new JAXBElement<CheckLogin>(_CheckLogin_QNAME, CheckLogin.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link CheckLoginResponse }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link CheckLoginResponse }{@code >}
     */
    @XmlElementDecl(namespace = "http://services.kulijawa.com/", name = "checkLoginResponse")
    public JAXBElement<CheckLoginResponse> createCheckLoginResponse(CheckLoginResponse value) {
        return new JAXBElement<CheckLoginResponse>(_CheckLoginResponse_QNAME, CheckLoginResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link DeleteUser }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link DeleteUser }{@code >}
     */
    @XmlElementDecl(namespace = "http://services.kulijawa.com/", name = "deleteUser")
    public JAXBElement<DeleteUser> createDeleteUser(DeleteUser value) {
        return new JAXBElement<DeleteUser>(_DeleteUser_QNAME, DeleteUser.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link DeleteUserResponse }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link DeleteUserResponse }{@code >}
     */
    @XmlElementDecl(namespace = "http://services.kulijawa.com/", name = "deleteUserResponse")
    public JAXBElement<DeleteUserResponse> createDeleteUserResponse(DeleteUserResponse value) {
        return new JAXBElement<DeleteUserResponse>(_DeleteUserResponse_QNAME, DeleteUserResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link RegisterUser }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link RegisterUser }{@code >}
     */
    @XmlElementDecl(namespace = "http://services.kulijawa.com/", name = "registerUser")
    public JAXBElement<RegisterUser> createRegisterUser(RegisterUser value) {
        return new JAXBElement<RegisterUser>(_RegisterUser_QNAME, RegisterUser.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link RegisterUserResponse }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link RegisterUserResponse }{@code >}
     */
    @XmlElementDecl(namespace = "http://services.kulijawa.com/", name = "registerUserResponse")
    public JAXBElement<RegisterUserResponse> createRegisterUserResponse(RegisterUserResponse value) {
        return new JAXBElement<RegisterUserResponse>(_RegisterUserResponse_QNAME, RegisterUserResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link UpdateUser }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link UpdateUser }{@code >}
     */
    @XmlElementDecl(namespace = "http://services.kulijawa.com/", name = "updateUser")
    public JAXBElement<UpdateUser> createUpdateUser(UpdateUser value) {
        return new JAXBElement<UpdateUser>(_UpdateUser_QNAME, UpdateUser.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link UpdateUserResponse }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link UpdateUserResponse }{@code >}
     */
    @XmlElementDecl(namespace = "http://services.kulijawa.com/", name = "updateUserResponse")
    public JAXBElement<UpdateUserResponse> createUpdateUserResponse(UpdateUserResponse value) {
        return new JAXBElement<UpdateUserResponse>(_UpdateUserResponse_QNAME, UpdateUserResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ViewNotifications }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link ViewNotifications }{@code >}
     */
    @XmlElementDecl(namespace = "http://services.kulijawa.com/", name = "viewNotifications")
    public JAXBElement<ViewNotifications> createViewNotifications(ViewNotifications value) {
        return new JAXBElement<ViewNotifications>(_ViewNotifications_QNAME, ViewNotifications.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ViewNotificationsResponse }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link ViewNotificationsResponse }{@code >}
     */
    @XmlElementDecl(namespace = "http://services.kulijawa.com/", name = "viewNotificationsResponse")
    public JAXBElement<ViewNotificationsResponse> createViewNotificationsResponse(ViewNotificationsResponse value) {
        return new JAXBElement<ViewNotificationsResponse>(_ViewNotificationsResponse_QNAME, ViewNotificationsResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ViewPurchases }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link ViewPurchases }{@code >}
     */
    @XmlElementDecl(namespace = "http://services.kulijawa.com/", name = "viewPurchases")
    public JAXBElement<ViewPurchases> createViewPurchases(ViewPurchases value) {
        return new JAXBElement<ViewPurchases>(_ViewPurchases_QNAME, ViewPurchases.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ViewPurchasesResponse }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link ViewPurchasesResponse }{@code >}
     */
    @XmlElementDecl(namespace = "http://services.kulijawa.com/", name = "viewPurchasesResponse")
    public JAXBElement<ViewPurchasesResponse> createViewPurchasesResponse(ViewPurchasesResponse value) {
        return new JAXBElement<ViewPurchasesResponse>(_ViewPurchasesResponse_QNAME, ViewPurchasesResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ViewUsers }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link ViewUsers }{@code >}
     */
    @XmlElementDecl(namespace = "http://services.kulijawa.com/", name = "viewUsers")
    public JAXBElement<ViewUsers> createViewUsers(ViewUsers value) {
        return new JAXBElement<ViewUsers>(_ViewUsers_QNAME, ViewUsers.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ViewUsersResponse }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link ViewUsersResponse }{@code >}
     */
    @XmlElementDecl(namespace = "http://services.kulijawa.com/", name = "viewUsersResponse")
    public JAXBElement<ViewUsersResponse> createViewUsersResponse(ViewUsersResponse value) {
        return new JAXBElement<ViewUsersResponse>(_ViewUsersResponse_QNAME, ViewUsersResponse.class, null, value);
    }

}
