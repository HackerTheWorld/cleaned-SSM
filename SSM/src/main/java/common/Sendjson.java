package common;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;

public class Sendjson {
	
	private String resNode=null;
	private Map sendParam = new HashMap();
	private int resCode = 0;
	private List jsonarray= new ArrayList();
	
	public Sendjson() {}
	
	public Sendjson(String resNode) {
		this.resNode = resNode;
	}
	
	public Sendjson(int resCode) {
		this.resCode = resCode;
	}
	
	public Sendjson(Map sendParam) {
		this.sendParam = sendParam;
	}
	
	public List getJsonarray() {
		return jsonarray;
	}

	public void setJsonarray(List list) {
		this.jsonarray = list;
	}

	public Sendjson(String resNode,Map sendParam) {
		this.resNode = resNode;
		this.sendParam = sendParam;
	}
	
	public Sendjson(int resCode,Map sendParam) {
		this.resCode = resCode;
		this.sendParam = sendParam;
	}
	
	public Sendjson(String resNode,Map sendParam,int resCode) {
		this.resNode = resNode;
		this.sendParam = sendParam;
		this.resCode = resCode;
	}
	
	public JSONObject changetype() {
		JSONObject jsonobject = new JSONObject();
		if(!jsonarray.isEmpty()||jsonarray.size()!=0)
			sendParam.put("sendList", jsonarray);
		jsonobject.put("resNode", resNode);
		jsonobject.put("sendParam", sendParam);
		jsonobject.put("resCode", resCode);
		return jsonobject;
	}

	public String getResNode() {
		return resNode;
	}

	public void setResNode(String resNode) {
		this.resNode = resNode;
	}

	public int getResCode() {
		return resCode;
	}

	public void setResCode(int resCode) {
		this.resCode = resCode;
	}

	public Map getSendParam() {
		return sendParam;
	}

	public void setSendParam(Map sendParam) {
		this.sendParam = sendParam;
	}
	

}
