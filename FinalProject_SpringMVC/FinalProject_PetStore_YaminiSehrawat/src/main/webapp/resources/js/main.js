$(document).ready(function(){
$("#signup").click(function() {
$("#loginForm").fadeOut("slow", function() {
$("#signUpForm").fadeIn("3000");
});
});
// On Click SignIn It Will Hide Registration Form and Display Login Form
$("#signin").click(function() {
$("#signUpForm").fadeOut("slow", function() {
$("#loginForm").fadeIn("3000");
});
});
});