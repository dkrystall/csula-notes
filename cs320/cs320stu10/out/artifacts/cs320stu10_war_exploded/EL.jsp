<%--
  Created by IntelliJ IDEA.
  User: dkrystall
  Date: 11/10/15
  Time: 1:51 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap.min.css" integrity="sha512-dTfge/zgoMYpP7QbHy4gWMEGsbsdZeCXz7irItjcC3sPUFtf0kuFbDz/ixG7ArTxmDjLXDmezHubeNikyKGVyQ==" crossorigin="anonymous">

  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap-theme.min.css" integrity="sha384-aUGj/X2zp5rLCbBxumKTCw2Z50WgIr1vs/PFN4praOTvYXWlVyh2UtNUU0KAUhAX" crossorigin="anonymous">

  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/js/bootstrap.min.js" integrity="sha512-K1qjQ+NcF2TYO/eI3M6v8EiNYZfA95pQumfvcVrTHtwQVDG+aHRqLi/ETn2uB+1JqwYqVG3LIvdm9lj6imS/pQ==" crossorigin="anonymous"></script>
    <title>Tables</title>
</head>
<body class = "container">
  <table class="table table-striped table-bordered">
    <thead>
      <tr>
        <th> Arithmetic Operators </th>
        <th></th>
        <th> Relational Operators </th>
        <th></th>
      </tr>
      <tr>
        <th class="col-md-4"> Expression</th>
        <th class="col-md-2">Result</th>
        <th class="col-md-4">Expression</th>
        <th class="col-md-2">Result</th>
      </tr>
    </thead>
    <tbody>
      <tr>
        <td class="col-md-4">
            \${3+2-1}
        </td>
        <td class="col-md-2">
            ${3+2-1}
        </td>
        <td class="col-md-4 ">
            \${1<2}
        </td>
        <td class="col-md-2">
          ${1<2}
        </td>
      </tr>
      <tr>
        <td class="col-md-4">
          \${"1"+2}
        </td>
        <td class="col-md-2">
          ${"1"+2}
        </td>
        <td class="col-md-4 ">
          \${"a"<"b"}
        </td>
        <td class="col-md-2">
          ${"a"<"b"}
        </td>
      </tr>
      <tr>
        <td class="col-md-4">
          \${1 + 2*3 + 3/4}
        </td>
        <td class="col-md-2">
          ${1 + 2*3 + 3/4}
        </td>
        <td class="col-md-4 ">
          \${2/3>=3/2}
        </td>
        <td class="col-md-2">
          ${2/3>=3/2}
        </td>
      </tr>
      <tr>
        <td class="col-md-4">
          \${3%2}
        </td>
        <td class="col-md-2">
          ${3%2}
        </td>
        <td class="col-md-4 ">
          \${3/4 == 0.75}
        </td>
        <td class="col-md-2">
          ${3/4 == 0.75}
        </td>
      </tr>
      <tr>
        <td class="col-md-4">
          \${(8 div 2) mod 3}
        </td>
        <td class="col-md-2">
          ${(8 div 2) mod 3}
        </td>
        <td class="col-md-4 ">
          \${null == "test"}
        </td>
        <td class="col-md-2">
          ${null == "test"}
        </td>
      </tr>
      <tr>
        <th> Arithmetic Operators</th>
        <th></th>
        <th><code>empty</code> Operators</th>
        <th></th>
      </tr>
      <tr>
        <th class="col-md-4 table-cell"> Expression</th>
        <th class="col-md-2 table-cell">Result</th>
        <th class="col-md-4 table-cell">Expression</th>
        <th class="col-md-2 table-cell">Result</th>
      </tr>
      <tr>
        <td class="col-md-4">
          \${(1<2)&&(4<3)}
        </td>
        <td class="col-md-2">
          ${(1<2)&&(4<3)}
        </td>
        <td class="col-md-4 ">
          \${empty""}
        </td>
        <td class="col-md-2">
          ${empty""}
        </td>
      </tr>
      <tr>
        <td class="col-md-4">
          \${(1<2) && (4<3)}
        </td>
        <td class="col-md-2">
          ${(1<2) && (4<3)}
        </td>
        <td class="col-md-4 ">
          \${empty null}
        </td>
        <td class="col-md-2">
          ${empty null}
        </td>
      </tr>
      <tr>
        <td class="col-md-4">
          \${!(1<2)}
        </td>
        <td class="col-md-2">
          ${!(1<2)}
        </td>
        <td class="col-md-4 ">
          \${(empty param.blah)}
        </td>
        <td class="col-md-2">
          ${(empty param.blah)}
        </td>
      </tr>
    </tbody>
  </table>
</body>
</html>
