function checkSearch(myform)
{
	if(!myform.name.value.length){
		window.alert("搜索内容不能为空!");
		myform.name.focus();
		return false;
	}
	else
	{
		myform.submit();
		return true;
	}
}
