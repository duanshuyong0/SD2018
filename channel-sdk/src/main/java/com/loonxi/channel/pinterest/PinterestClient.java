package com.loonxi.channel.pinterest;


import java.io.InputStream;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.google.gson.Gson;
import com.loonxi.channel.common.HttpClientUtil;
import com.loonxi.channel.common.JacksonUtil;
import com.loonxi.channel.pinterest.model.Boards;
import com.loonxi.channel.pinterest.model.Pins;
import com.loonxi.channel.pinterest.model.UserProfile;

/**
 * 
 * @describe  
 * @author guoxubin
 * @date 2016年10月11日
 *
 */
public class PinterestClient {
    
	public final String APIHOST = "https://api.pinterest.com/v1/";
	public final String AUTH_URL = "https://api.pinterest.com/oauth/";
	
	private String client_id;
	private String client_secret;
	
	/**
	 * 
	 * @param client_id
	 * @param client_secret
	 */
	public PinterestClient(String client_id,String client_secret){
		this.client_id = client_id;
		this.client_secret = client_secret;
	}

    /**
     * 
     * @describe
     * @author guoxubin
     * @date 2016年10月12日
     *
     * @param state 自定义参数，pinterest会返回
     * @param redirect_uri 必须为应用后台设置地址
     * @return
     */
    public String authUrl(String state,String redirect_uri){
        String url = AUTH_URL +
                    "?response_type=code" +
                    "&redirect_uri=" +redirect_uri +
                    "&client_id=" + client_id +
                    "&scope=read_public,write_public" +
                    "&state=" + state;
        return url;
    }

    /**
     * 
     * @describe 获取 token
     * @author guoxubin
     * @date 2016年10月11日
     *
     * @param code
     * @return
     * @throws Exception
     */
    public String accessToken(String code) throws Exception{
        String apiUrl = APIHOST + "oauth/token";
        Map<String, Object> params = new HashMap<String, Object>();
        params.put("grant_type", "authorization_code");
        params.put("client_id", client_id);
        params.put("client_secret", client_secret);
        params.put("code", code);

    	String result = HttpClientUtil.httpPostRequest(apiUrl, params);
    	Gson gson = new Gson();
    	Map<String, Object> map = gson.fromJson(result, Map.class);
    	if(null == map.get("access_token")){
    		throw new Exception(result);
    	}
        return map.get("access_token").toString();
    }

    /**
     * 获取 用户信息
     * @param accessToken
     * the api result like this
     * {
        "data": {
            "url": "https://www.pinterest.com/qi7366/",
            "first_name": "Qi",
            "last_name": "",
            "id": "822188613130260890"
            "image":{
                    "60*60":{url:}
                }
            }
        }
     *
     * @return
     * @throws Exception 
     */
    public UserProfile userProfile(String accessToken) throws Exception{
        String apiUrl = APIHOST + "me/";
        
        Map<String,Object> params = new HashMap<String,Object>();
        params.put("access_token", accessToken);
        params.put("fields","first_name,last_name,account_type,username,created_at,image");

    	String result = HttpClientUtil.httpGetRequest(apiUrl,params);
    	Gson gson = new Gson();
    	Map<String, Object> map = gson.fromJson(result, Map.class);

    	System.out.println(" pins user result --- "+map);

    	if(null == map.get("data")){
    		throw new Exception(result);
    	}
    	UserProfile userProfile = new UserProfile();
        Map<String, Object> info = (Map)map.get("data");
        userProfile.setUrl((String)info.get("url"));
        userProfile.setUserId((String)info.get("id"));
        //解析出username
        String username = info.get("first_name") + " " + info.get("last_name");
        userProfile.setUsername(username);
        //获取头像
        Map<String,String> imageMap = (Map)((Map)info.get("image")).get("60x60");
        userProfile.setAvatar(imageMap.get("url"));
        System.out.println(" pins user result --- "+ JacksonUtil.toJsonStr(userProfile));
        return userProfile;
       
    }

    /**
     * 获取画板列表
     * @param accessToken
     *
     * {
        "data": [
            {
                "url": "https://www.pinterest.com/qi7366/hehe/",
                "id": "822188544410783881",
                "name": "hehe"
            },
            {
                "url": "https://www.pinterest.com/qi7366/%E8%9C%80%E5%B1%B1%E6%8E%8C%E9%97%A8/",
                "id": "822188544410785236",
                "name": "蜀山掌门"
            }
        ]
        }
     *
     * @return
     * @throws Exception 
     */
    public List<Boards> boardsList(String accessToken) throws Exception{
        String apiUrl = APIHOST + "me/boards/";
        
        Map<String,Object> params = new HashMap<String,Object>();
        params.put("access_token", accessToken);
        
    	String result = HttpClientUtil.httpGetRequest(apiUrl,params);
    	Gson gson = new Gson();
    	Map<String, Object> map = gson.fromJson(result, Map.class);
    	List<Boards> list = new ArrayList<Boards>();
    	if(null == map.get("data")){
    		throw new Exception(result);
    	}
        List<Map<String, String>> info = (List)map.get("data");
        for(Map<String, String> dd : info){
            Boards boards = new Boards();
            boards.setUrl(dd.get("url"));
            boards.setId(dd.get("id"));
            boards.setName(dd.get("name"));
            list.add(boards);
        }
        return list;
    }

    /**
     * 创建画板
     *
     * {
         "data": {
             "url": "https://www.pinterest.com/qi7366/onloon-test/",
             "id": "822188544410785290",
             "name": "onloon-test"
         }
     }
     *
     * @param accessToken
     * @param name
     * @param description
     * @return
     * @throws Exception 
     */
    public Boards createBoards(String accessToken, String name, String... description) throws Exception{
        String apiUrl = APIHOST + "boards/";

        Map<String, Object> params = new HashMap<String,Object>();
        params.put("access_token", accessToken);
        params.put("name", name);
        if(description.length>0){
            params.put("description",description[0]);
        }
        
    	String result = HttpClientUtil.httpPostRequest(apiUrl, params);
    	Gson gson = new Gson();
    	Map<String, Object> map = gson.fromJson(result, Map.class);
    	Boards boards = new Boards();
    	if(null == map.get("data")){
    		throw new Exception(result);
    	}
        Map<String, String> info = (Map)map.get("data");
        boards.setUrl(info.get("url"));
        boards.setId(info.get("id"));
        boards.setName(info.get("name"));
        return boards;   
    }

    /**
     * 
     * @describe
     * @author guoxubin
     * @date 2016年10月12日
     *
     * @param accessToken
     * @param note      备注
     * @param boardId   画板id
     * @param imageUrl  图片地址
     * @param srcLink   图片来源地址(点击图片跳转地址)
     * @return
     * @throws Exception
     */
    public Pins createPins(String accessToken, String note, String boardId, String imageUrl, String srcLink) throws Exception{
    	/**InputStream in = null;
    	try {
            URL url = new URL(imageUrl);
            // 返回一个 URLConnection 对象，它表示到 URL 所引用的远程对象的连接。
            URLConnection uc = url.openConnection();
            // 打开的连接读取的输入流。
            in = uc.getInputStream();
        } catch (Exception e) {
            throw new Exception("can not get the image");
        }finally {
			if(null != in){
				in.close();
			}
		}**/
    	String apiUrl = APIHOST + "pins/";

        Map<String, Object> params = new HashMap<String,Object>();
        params.put("access_token", accessToken);
        params.put("board",  boardId);
        params.put("note", accessToken);
        params.put("image_url", imageUrl);
        params.put("link", srcLink);
        params.put("note", note);
      
    	String result = HttpClientUtil.httpPostRequest(apiUrl, params);
    	Gson gson = new Gson();
    	Map<String, Object> map = gson.fromJson(result, Map.class);
    	if(null == map.get("data")){
    		throw new Exception(result);
    	}
        Map<String,Object> info = (Map<String, Object>) map.get("data");
        Pins pins = new Pins();
        pins.setId((String) info.get("id"));
        pins.setLink((String) info.get("link"));
        pins.setNote((String) info.get("note"));
        pins.setUrl((String) info.get("url"));
        return pins;   
    }

}
