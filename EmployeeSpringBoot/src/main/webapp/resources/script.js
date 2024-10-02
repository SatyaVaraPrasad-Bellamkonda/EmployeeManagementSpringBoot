document.getElementById('insertButton').addEventListener('click', function() {
	window.location.href = 'insertEmployeeDetails';
});
document.getElementById('viewActiveEmployeeButton').addEventListener('click', function() {
	window.location.href = 'activeEmployeeData';
});
document.getElementById('deleteButton').addEventListener('click', function() {
	window.location.href = 'employeeDeleteById';
});
document.getElementById('updateButton').addEventListener('click', function() {
	window.location.href = 'employeeUpdateById';
});
document.getElementById('viewRequests').addEventListener('click', function() {
	window.location.href = 'viewEmployeeRequests';
});
document.getElementById('logout').addEventListener('click', function() {
	window.location.href = 'logout';
});
document.getElementById('viewDbDataButton').addEventListener('click', function() {
	window.location.href = 'completeEmployeeData';
});
document.getElementById('profile').addEventListener('click', function() {
	window.location.href = 'userProfile';
});
document.getElementById('changePasswordButton').addEventListener('click', function() {
	window.location.href = 'changePassword';
});