package action.market;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.util.List;
import java.util.Map;

import org.apache.struts2.interceptor.RequestAware;

import com.opensymphony.xwork2.ModelDriven;

import entity.market.Channel;

import service.market.ChannelService;
import util.system.Pagable;

public class ChannelAction implements RequestAware,ModelDriven<Channel>{
	private Map<String,Object> request;
	private ChannelService channelservice;
	private Channel channel =new Channel();
	private Pagable pagable = new Pagable();
	private InputStream inputStream;
	
	
	public Pagable getPagable() {
		return pagable;
	}
	public void setPagable(Pagable pagable) {
		this.pagable = pagable;
	}
	
	public InputStream getInputStream() {
		return inputStream;
	}
	public void setInputStream(InputStream inputStream) {
		this.inputStream = inputStream;
	}
	
	public Channel getChannel() {
		return channel;
	}
	public void setChannel(Channel channel) {
		this.channel = channel;
	}
	public ChannelService getChannelservice() {
		return channelservice;
	}
	public void setChannelservice(ChannelService channelservice) {
		this.channelservice = channelservice;
	}
	public void setRequest(Map<String, Object> request) {
		// TODO Auto-generated method stub
		this.request=request;
	}
	public Channel getModel() {
		// TODO Auto-generated method stub
		return channel;
	}
	public String findAll(){
		List<Channel> cl =  (List<Channel>) channelservice.findByPage(pagable.getPage(), pagable.getRows());
		pagable.setTotal(channelservice.count());
		request.put("cl", cl);
		request.put("pagable", pagable);
		return "success";
	}
	public String update(){
		channelservice.update(channel);
		return "change";
	}
	
	public String edit(){
		Channel cl = channelservice.findOne(channel.getId());
		request.put("cl", cl);
		return "success";
	}
	public String change(){
		int id=channel.getId();
		int state = channelservice.findOne(channel.getId()).getState();
		channelservice.change(state, id);
		return "change";
	}
	public String add(){
		channelservice.save(channel);
		return "add";
	}
	public String test(){
		String state="";
		state =channelservice.test(channel.getName());
		System.out.println(state);
		try {
			inputStream=new ByteArrayInputStream(state.getBytes("utf-8"));
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		System.out.println(state);
		return "test";
	}

}
