# Aspartame

Aspartame makes it easier to integrate [Sugar ORM](http://satyan.github.io/sugar/) with [Retrofit](http://square.github.io/retrofit/).

## Installation

Add this project to your IDE as an Android Library. Execute the following command to download dependencies:

    $ mvn install

## Usage

Follow [Sugar's instructions](http://satyan.github.io/sugar/getting-started.html) to set up your project and build your model entities.

	public class User extends SugarRecord<User> {
	
	    @SerializedName( "id" )
	    Integer externalId;
	
	    public User() {
	    	
	        super( SugarApp.getSugarContext() );
	    }
	
	    public Integer getExternalId() {
	
	        return externalId;
	    }
	
	    public void setExternalId( Integer externalId ) {
	
	        this.externalId = externalId;
	    }
	}

Follow [Retrofit's instructions](http://square.github.io/retrofit/) to build your service interfaces.

	public interface UserService {
	
	    // example of an asynchronous request: handles threading and invokes a callback.
	    @POST( "/users.json" )
	    void create( @Body User resource, Callback<User> callback );
	
	    // example of a synchronous request, no callback.
	    @POST( "/users/sign_in.json" )
	    UserResponse login( @Body User resource );
	}

You may then make use of Aspartame to tie everything together:

	UserService userService = Aspartame.newService( "http://api.example.com/", UserService.class );
	UserResponse userResponse = userService.login( user );
