package entity.market;

import entity.system.User;

public class Customer {
	
	private Long id;//编号
	private Long id_number;//身份证号
	private String name;//姓名
	private Long tel;//电话
	private String sex;//性别
	private Long qq;//QQ
	private Long customertype;//客户类型
	private String major;//专业
	private String school;//学校
	private Consulation consulation;//咨询类别
	private Channel channel;//渠道
	private String city;//城市
	private String education;//学历
	private State state;//客户状态 未跟进,跟进-未上门,跟进-已上门,跟进-已报名,不考虑
	private Long intention;//意向,0或1:犹豫,积极
	private String time;//入学时间
	private User founder;//创建人private 
	private User consultant;//所属咨询师private 
	private String context;//咨询内容
	public Customer() {
		super();
	}
	public Long getQq() {
		return qq;
	}
	@Override
	public String toString() {
		return "Customer [id=" + id + ", id_number=" + id_number + ", name="
				+ name + ", tel=" + tel + ", sex=" + sex + ", qq=" + qq
				+ ", customertype=" + customertype + ", major=" + major
				+ ", school=" + school + ", consulation=" + consulation
				+ ", channel=" + channel + ", city=" + city + ", education="
				+ education + ", state=" + state + ", intention=" + intention
				+ ", time=" + time + ", founder=" + founder + ", consultant="
				+ consultant + ", context=" + context + "]";
	}
	public void setQq(Long qq) {
		this.qq = qq;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Long getId_number() {
		return id_number;
	}
	public void setId_number(Long id_number) {
		this.id_number = id_number;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Long getTel() {
		return tel;
	}
	public void setTel(Long tel) {
		this.tel = tel;
	}
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	
	
	public Long getCustomertype() {
		return customertype;
	}
	public void setCustomertype(Long customertype) {
		this.customertype = customertype;
	}
	public String getMajor() {
		return major;
	}
	public void setMajor(String major) {
		this.major = major;
	}
	public String getSchool() {
		return school;
	}
	public void setSchool(String school) {
		this.school = school;
	}
	
	public Consulation getConsulation() {
		return consulation;
	}
	public void setConsulation(Consulation consulation) {
		this.consulation = consulation;
	}
	public Channel getChannel() {
		return channel;
	}
	public void setChannel(Channel channel) {
		this.channel = channel;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getEducation() {
		return education;
	}
	public void setEducation(String education) {
		this.education = education;
	}
	public State getState() {
		return state;
	}
	public void setState(State state) {
		this.state = state;
	}
	public Long getIntention() {
		return intention;
	}
	public void setIntention(Long intention) {
		this.intention = intention;
	}
	public String getTime() {
		return time;
	}
	public void setTime(String time) {
		this.time = time;
	}
	public User getFounder() {
		return founder;
	}
	public void setFounder(User founder) {
		this.founder = founder;
	}
	public User getConsultant() {
		return consultant;
	}
	public void setConsultant(User consultant) {
		this.consultant = consultant;
	}
	public String getContext() {
		return context;
	}
	public void setContext(String context) {
		this.context = context;
	}
	
	
	
}
