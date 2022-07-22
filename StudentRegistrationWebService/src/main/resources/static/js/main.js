

$(document).ready(function(){
	
	$("#registerStudentsButton").click(function() {
	    $('html, body').animate({
	        scrollTop: $("#studentFormAndTableSection").offset().top
	    }, 1000);
	});
	
  
	GetAllStudents();

	$("#student-registration-form").submit(function (event) {
        event.preventDefault();
        StudentRegisterAjaxSubmit();
    });
});

function GetAllStudents() {
	  $.ajax({
          type: 'GET',
          url: 'http://localhost:8080/students/',
          success: function(studentsArray) {
              var studentsTbody = $('#student-table-body');
 
      
              $.each(studentsArray, function(index, student) {
                  var studentInfo = '<tr class="student-info">';
                  studentInfo += '<th scope="row">' + student.id + '</th>';
                  studentInfo += '<td>' + student.name + '</td>';
                  studentInfo += '<td>' + student.age + '</td>';
                  studentInfo += '<td>' + student.mobile + '</td>';
                  studentInfo += '<td>' + student.address + '</td>';
                  studentInfo += '</tr>';
                  studentsTbody.append(studentInfo);
              })
          },
          error: function() {alert('FAILURE!');
        }
      });
}

function StudentRegisterAjaxSubmit() {

    var student = {}
   
    student["name"] = $("#name").val();
    student["age"] = $("#age").val();
    student["mobile"] = $("#mobile").val();
    student["address"] = $("#address").val();
    
    $.ajax({
        type: "POST",
        contentType: "application/json",
        url: "/students",
        data: JSON.stringify(student),
        dataType: 'json',
        success: function (data) {
            var studentsInfo = $('.student-info');
            studentsInfo.remove();
            GetAllStudents();
        },
        error: function (e) {
            alert(student["name"] + " register failed!");
        }
    });

}