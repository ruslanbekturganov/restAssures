package api.endpoints;

//	post	https://petstore.swagger.io/v2/
//	get     https://petstore.swagger.io/v2/user/{username}
//	put     https://petstore.swagger.io/v2/user/{username}
//	delete	https://petstore.swagger.io/v2/user/{username}



public class Routes {
	
	public static String baseUrl = "https://petstore.swagger.io/v2";
	
	public static String postUrl=baseUrl+"/user";
	public static String getUrl=baseUrl+"/user/{username}";
	public static String updateUrl=baseUrl+"/user/{username}";
	public static String deleteUrl=baseUrl+"/user/{username}";




}
