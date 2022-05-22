package b4a.example;


import anywheresoftware.b4a.BA;
import anywheresoftware.b4a.B4AClass;
import anywheresoftware.b4a.BALayout;
import anywheresoftware.b4a.debug.*;

public class edit_note extends B4AClass.ImplB4AClass implements BA.SubDelegator{
    private static java.util.HashMap<String, java.lang.reflect.Method> htSubs;
    private void innerInitialize(BA _ba) throws Exception {
        if (ba == null) {
            ba = new BA(_ba, this, htSubs, "b4a.example.edit_note");
            if (htSubs == null) {
                ba.loadHtSubs(this.getClass());
                htSubs = ba.htSubs;
            }
            
        }
        if (BA.isShellModeRuntimeCheck(ba)) 
			   this.getClass().getMethod("_class_globals", b4a.example.edit_note.class).invoke(this, new Object[] {null});
        else
            ba.raiseEvent2(null, true, "class_globals", false);
    }

 public anywheresoftware.b4a.keywords.Common __c = null;
public anywheresoftware.b4a.objects.B4XViewWrapper _root = null;
public anywheresoftware.b4a.objects.B4XViewWrapper.XUI _xui = null;
public anywheresoftware.b4a.sql.SQL.CursorWrapper _sqlcursor = null;
public anywheresoftware.b4a.objects.EditTextWrapper _contentinput = null;
public anywheresoftware.b4a.objects.EditTextWrapper _titleinput = null;
public b4a.example.note _notepage = null;
public b4a.example.b4ximageview _imagecon = null;
public anywheresoftware.b4a.phone.Phone.ContentChooser _cc = null;
public String _imagepath = "";
public b4a.example.dateutils _dateutils = null;
public b4a.example.main _main = null;
public b4a.example.starter _starter = null;
public b4a.example.b4xpages _b4xpages = null;
public b4a.example.b4xcollections _b4xcollections = null;
public b4a.example.xuiviewsutils _xuiviewsutils = null;
public String  _b4xpage_appear() throws Exception{
 //BA.debugLineNum = 40;BA.debugLine="Sub b4xpage_appear";
 //BA.debugLineNum = 41;BA.debugLine="sqlCursor = Starter.SQL1.ExecQuery(\"SELECT * FROM";
_sqlcursor = (anywheresoftware.b4a.sql.SQL.CursorWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.sql.SQL.CursorWrapper(), (android.database.Cursor)(_starter._sql1 /*anywheresoftware.b4a.sql.SQL*/ .ExecQuery("SELECT * FROM notes WHERE id = '"+_b4xpages._mainpage /*b4a.example.b4xmainpage*/ (ba)._noteid /*String*/ +"' ")));
 //BA.debugLineNum = 42;BA.debugLine="sqlCursor.Position = 0";
_sqlcursor.setPosition((int) (0));
 //BA.debugLineNum = 44;BA.debugLine="titleInput.Text = sqlCursor.GetString(\"title\")";
_titleinput.setText(BA.ObjectToCharSequence(_sqlcursor.GetString("title")));
 //BA.debugLineNum = 45;BA.debugLine="contentInput.Text = sqlCursor.GetString(\"body\")";
_contentinput.setText(BA.ObjectToCharSequence(_sqlcursor.GetString("body")));
 //BA.debugLineNum = 47;BA.debugLine="If sqlCursor.GetString(\"image\") = \"null\" Then";
if ((_sqlcursor.GetString("image")).equals("null")) { 
 //BA.debugLineNum = 48;BA.debugLine="ImageCon.Load(File.DirAssets, \"image.jpg\")";
_imagecon._load /*String*/ (__c.File.getDirAssets(),"image.jpg");
 }else {
 //BA.debugLineNum = 50;BA.debugLine="If imagePath = \"null\" Then";
if ((_imagepath).equals("null")) { 
 //BA.debugLineNum = 51;BA.debugLine="ImageCon.Load(File.DirInternal, sqlCursor.GetSt";
_imagecon._load /*String*/ (__c.File.getDirInternal(),_sqlcursor.GetString("image"));
 };
 };
 //BA.debugLineNum = 54;BA.debugLine="End Sub";
return "";
}
public String  _b4xpage_created(anywheresoftware.b4a.objects.B4XViewWrapper _root1) throws Exception{
b4a.example.b4xpagesmanager._b4amenuitem _savebtn = null;
 //BA.debugLineNum = 22;BA.debugLine="Private Sub B4XPage_Created (Root1 As B4XView)";
 //BA.debugLineNum = 23;BA.debugLine="Root = Root1";
_root = _root1;
 //BA.debugLineNum = 25;BA.debugLine="Root.LoadLayout(\"editnotelayout\")";
_root.LoadLayout("editnotelayout",ba);
 //BA.debugLineNum = 26;BA.debugLine="B4XPages.SetTitle(Me, \"Edit\")";
_b4xpages._settitle /*String*/ (ba,this,(Object)("Edit"));
 //BA.debugLineNum = 28;BA.debugLine="Dim saveBtn As B4AMenuItem = B4XPages.AddMenuItem";
_savebtn = _b4xpages._addmenuitem /*b4a.example.b4xpagesmanager._b4amenuitem*/ (ba,this,(Object)("🗒️ Update"));
 //BA.debugLineNum = 29;BA.debugLine="saveBtn.AddToBar = True";
_savebtn.AddToBar /*boolean*/  = __c.True;
 //BA.debugLineNum = 31;BA.debugLine="notepage.Initialize";
_notepage._initialize /*Object*/ (ba);
 //BA.debugLineNum = 32;BA.debugLine="B4XPages.AddPage(\"notepage\", notepage)";
_b4xpages._addpage /*String*/ (ba,"notepage",(Object)(_notepage));
 //BA.debugLineNum = 35;BA.debugLine="ImageCon.Load(File.DirAssets, \"image.jpg\")";
_imagecon._load /*String*/ (__c.File.getDirAssets(),"image.jpg");
 //BA.debugLineNum = 37;BA.debugLine="CC.Initialize(\"CC\")";
_cc.Initialize("CC");
 //BA.debugLineNum = 38;BA.debugLine="End Sub";
return "";
}
public String  _b4xpage_disappear() throws Exception{
 //BA.debugLineNum = 56;BA.debugLine="Sub b4xpage_disappear";
 //BA.debugLineNum = 57;BA.debugLine="imagePath = \"null\"";
_imagepath = "null";
 //BA.debugLineNum = 58;BA.debugLine="End Sub";
return "";
}
public String  _b4xpage_menuclick(String _tag) throws Exception{
 //BA.debugLineNum = 60;BA.debugLine="Sub b4xpage_MenuClick (Tag As String)";
 //BA.debugLineNum = 61;BA.debugLine="If Tag = \"🗒️ Update\" Then";
if ((_tag).equals("🗒️ Update")) { 
 //BA.debugLineNum = 62;BA.debugLine="update_note";
_update_note();
 };
 //BA.debugLineNum = 64;BA.debugLine="End Sub";
return "";
}
public String  _cc_result(boolean _success,String _dir,String _filename) throws Exception{
 //BA.debugLineNum = 89;BA.debugLine="Sub CC_Result (Success As Boolean, Dir As String,";
 //BA.debugLineNum = 90;BA.debugLine="DateTime.DateFormat=\"hh:mm:ss\"";
__c.DateTime.setDateFormat("hh:mm:ss");
 //BA.debugLineNum = 92;BA.debugLine="If Success = True Then";
if (_success==__c.True) { 
 //BA.debugLineNum = 93;BA.debugLine="ImageCon.Load(Dir, FileName)";
_imagecon._load /*String*/ (_dir,_filename);
 //BA.debugLineNum = 94;BA.debugLine="imagePath = \"image\" & DateTime.Date(DateTime.now";
_imagepath = "image"+__c.DateTime.Date(__c.DateTime.getNow())+".jpg";
 //BA.debugLineNum = 96;BA.debugLine="File.Copy(Dir, FileName, File.DirInternal, image";
__c.File.Copy(_dir,_filename,__c.File.getDirInternal(),_imagepath);
 }else {
 //BA.debugLineNum = 98;BA.debugLine="ToastMessageShow(\"No Success :(\",True)";
__c.ToastMessageShow(BA.ObjectToCharSequence("No Success :("),__c.True);
 };
 //BA.debugLineNum = 100;BA.debugLine="End Sub";
return "";
}
public String  _class_globals() throws Exception{
 //BA.debugLineNum = 1;BA.debugLine="Sub Class_Globals";
 //BA.debugLineNum = 2;BA.debugLine="Private Root As B4XView 'ignore";
_root = new anywheresoftware.b4a.objects.B4XViewWrapper();
 //BA.debugLineNum = 3;BA.debugLine="Private xui As XUI 'ignore";
_xui = new anywheresoftware.b4a.objects.B4XViewWrapper.XUI();
 //BA.debugLineNum = 4;BA.debugLine="Dim sqlCursor As Cursor";
_sqlcursor = new anywheresoftware.b4a.sql.SQL.CursorWrapper();
 //BA.debugLineNum = 6;BA.debugLine="Private contentInput As EditText";
_contentinput = new anywheresoftware.b4a.objects.EditTextWrapper();
 //BA.debugLineNum = 7;BA.debugLine="Private titleInput  As EditText";
_titleinput = new anywheresoftware.b4a.objects.EditTextWrapper();
 //BA.debugLineNum = 9;BA.debugLine="Dim notepage As note";
_notepage = new b4a.example.note();
 //BA.debugLineNum = 10;BA.debugLine="Private ImageCon As B4XImageView";
_imagecon = new b4a.example.b4ximageview();
 //BA.debugLineNum = 12;BA.debugLine="Dim CC As ContentChooser";
_cc = new anywheresoftware.b4a.phone.Phone.ContentChooser();
 //BA.debugLineNum = 13;BA.debugLine="Dim imagePath As String = Null";
_imagepath = BA.ObjectToString(__c.Null);
 //BA.debugLineNum = 14;BA.debugLine="End Sub";
return "";
}
public Object  _initialize(anywheresoftware.b4a.BA _ba) throws Exception{
innerInitialize(_ba);
 //BA.debugLineNum = 17;BA.debugLine="Public Sub Initialize As Object";
 //BA.debugLineNum = 18;BA.debugLine="Return Me";
if (true) return this;
 //BA.debugLineNum = 19;BA.debugLine="End Sub";
return null;
}
public String  _update_note() throws Exception{
 //BA.debugLineNum = 66;BA.debugLine="Sub update_note";
 //BA.debugLineNum = 67;BA.debugLine="If contentInput.Text = \"\" Or titleInput.Text = \"\"";
if ((_contentinput.getText()).equals("") || (_titleinput.getText()).equals("")) { 
 //BA.debugLineNum = 68;BA.debugLine="ToastMessageShow(\"Please fill out the fields\", T";
__c.ToastMessageShow(BA.ObjectToCharSequence("Please fill out the fields"),__c.True);
 }else {
 //BA.debugLineNum = 70;BA.debugLine="If imagePath = \"null\" Then";
if ((_imagepath).equals("null")) { 
 //BA.debugLineNum = 71;BA.debugLine="Starter.SQL1.ExecNonQuery2(\"UPDATE notes SET ti";
_starter._sql1 /*anywheresoftware.b4a.sql.SQL*/ .ExecNonQuery2("UPDATE notes SET title = ?, body = ? WHERE id = ?",anywheresoftware.b4a.keywords.Common.ArrayToList(new Object[]{(Object)(_titleinput.getText()),(Object)(_contentinput.getText()),(Object)(_b4xpages._mainpage /*b4a.example.b4xmainpage*/ (ba)._noteid /*String*/ )}));
 }else {
 //BA.debugLineNum = 73;BA.debugLine="Starter.SQL1.ExecNonQuery2(\"UPDATE notes SET ti";
_starter._sql1 /*anywheresoftware.b4a.sql.SQL*/ .ExecNonQuery2("UPDATE notes SET title = ?, body = ?, image = ? WHERE id = ?",anywheresoftware.b4a.keywords.Common.ArrayToList(new Object[]{(Object)(_titleinput.getText()),(Object)(_contentinput.getText()),(Object)(_imagepath),(Object)(_b4xpages._mainpage /*b4a.example.b4xmainpage*/ (ba)._noteid /*String*/ )}));
 };
 //BA.debugLineNum = 76;BA.debugLine="B4XPages.ShowPage(\"notepage\")";
_b4xpages._showpage /*String*/ (ba,"notepage");
 //BA.debugLineNum = 77;BA.debugLine="ToastMessageShow(\"Note updated.\", True)";
__c.ToastMessageShow(BA.ObjectToCharSequence("Note updated."),__c.True);
 };
 //BA.debugLineNum = 81;BA.debugLine="End Sub";
return "";
}
public String  _uploadimgbtn_click() throws Exception{
 //BA.debugLineNum = 85;BA.debugLine="Private Sub uploadImgBtn_Click";
 //BA.debugLineNum = 86;BA.debugLine="CC.Show(\"image/*\", \"Choose image\")";
_cc.Show(ba,"image/*","Choose image");
 //BA.debugLineNum = 87;BA.debugLine="End Sub";
return "";
}
public Object callSub(String sub, Object sender, Object[] args) throws Exception {
BA.senderHolder.set(sender);
if (BA.fastSubCompare(sub, "B4XPAGE_CREATED"))
	return _b4xpage_created((anywheresoftware.b4a.objects.B4XViewWrapper) args[0]);
return BA.SubDelegator.SubNotFound;
}
}
