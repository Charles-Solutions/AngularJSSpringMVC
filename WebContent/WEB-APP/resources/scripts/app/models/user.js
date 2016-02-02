app.factory('User', function () { 

	
	// Define the constructor function.
    function User(name, lastName, email) {
        this.name = name;
        this.lastName = lastName;
        this.email = email;
    }

    
     // Define the "instance" methods using the prototype
    // and standard prototypal inheritance.
    User.prototype = {

        getName: function() {
            return this.name;
        },

        getLastName: function() {
            return this.lastName;
        },
        
        getEmail: function() {
            return this.email;
        }

    };
    
    // Return constructor - this is what defines the actual
    // injectable in the DI framework.
    return User;	
		
});

