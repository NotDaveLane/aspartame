# Aspartame

Aspartame makes it easier to integrate [Sugar ORM](http://satyan.github.io/sugar/) with [Retrofit](http://square.github.io/retrofit/).

## Installation

Add this project to your IDE as an Android Library. Execute the following command to download dependencies, or use the JARs included in the libs directory:

    $ mvn install

## Usage

Follow [Sugar's instructions](http://satyan.github.io/sugar/getting-started.html) to set up your project and build your model entities. There are two modifications to these instructions:

 - Use a public zero-argument constructor for your model objects. Deserialization using [Gson](https://code.google.com/p/google-gson/) (a dependency of Retrofit) requires this.
 - Do not store API responses' `id` value as `id`. You do not want your Android SQLite database primary keys to be decreed by a remote server.

Here is a simple example model object:

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
	
	    // example of a synchronous request: no callback needed and work is performed on the current thread.
	    @POST( "/users/sign_in.json" )
	    UserResponse login( @Body User resource );
	}

You may then make use of Aspartame to tie everything together:

	UserService userService = Aspartame.newService( "http://api.example.com/", UserService.class );
	UserResponse userResponse = userService.login( user );
