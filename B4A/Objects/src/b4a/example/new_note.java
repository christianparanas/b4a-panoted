package b4a.example;


import anywheresoftware.b4a.BA;
import anywheresoftware.b4a.B4AClass;
import anywheresoftware.b4a.BALayout;
import anywheresoftware.b4a.debug.*;

public class new_note extends B4AClass.ImplB4AClass implements BA.SubDelegator{
    private static java.util.HashMap<String, java.lang.reflect.Method> htSubs;
    private void innerInitialize(BA _ba) throws Exception {
        if (ba == null) {
            ba = new BA(_ba, this, htSubs, "b4a.example.new_note");
            if (htSubs == null) {
                ba.loadHtSubs(this.getClass());
                htSubs = ba.htSubs;
            }
            
        }
        if (BA.isShellModeRuntimeCheck(ba)) 
			   this.getClass().getMethod("_class_globals", b4a.example.new_note.class).invoke(this, new Object[] {null});
        else
            ba.raiseEvent2(null, true, "class_globals", false);
    }

 public anywheresoftware.b4a.keywords.Common __c = null;
public anywheresoftware.b4a.objects.B4XViewWrapper _root = null;
public anywheresoftware.b4a.objects.B4XViewWrapper.XUI _xui = null;
public b4a.example.b4xmainpage _mainpage = null;
public anywheresoftware.b4a.objects.ButtonWrapper _uploadimgbtn = null;
public anywheresoftware.b4a.objects.EditTextWrapper _contentinput = null;
public anywheresoftware.b4a.objects.EditTextWrapper _titleinput = null;
public b4a.example.b4ximageview _imagecon = null;
public anywheresoftware.b4a.phone.Phone.ContentChooser _cc = null;
public String _imagepath = "";
public b4a.example.dateutils _dateutils = null;
public b4a.example.main _main = null;
public b4a.example.starter _starter = null;
public b4a.example.b4xpages _b4xpages = null;
public b4a.example.b4xcollections _b4xcollections = null;
public b4a.example.xuiviewsutils _xuiviewsutils = null;
public String  _addnote() throws Exception{
 //BA.debugLineNum = 41;BA.debugLine="Sub AddNote";
 //BA.debugLineNum = 42;BA.debugLine="If contentInput.Text = \"\" Or titleInput.Text = \"\"";
if ((_contentinput.getText()).equals("") || (_titleinput.getText()).equals("")) { 
 //BA.debugLineNum = 43;BA.debugLine="ToastMessageShow(\"Please fill out the fields\", T";
__c.ToastMessageShow(BA.ObjectToCharSequence("Please fill out the fields"),__c.True);
 }else {
 //BA.debugLineNum = 45;BA.debugLine="If imagePath = Null Then";
if (_imagepath== null) { 
 //BA.debugLineNum = 46;BA.debugLine="Starter.SQL1.ExecNonQuery(\"INSERT INTO notes (t";
_starter._sql1 /*anywheresoftware.b4a.sql.SQL*/ .ExecNonQuery("INSERT INTO notes (title, body) VALUES ('"+_titleinput.getText()+"', '"+_contentinput.getText()+")");
 }else {
 //BA.debugLineNum = 48;BA.debugLine="Starter.SQL1.ExecNonQuery(\"INSERT INTO notes (t";
_starter._sql1 /*anywheresoftware.b4a.sql.SQL*/ .ExecNonQuery("INSERT INTO notes (title, body, image) VALUES ('"+_titleinput.getText()+"', '"+_contentinput.getText()+"', '"+_imagepath+"')");
 };
 //BA.debugLineNum = 51;BA.debugLine="mainpage.Initialize";
_mainpage._initialize /*String*/ (ba);
 //BA.debugLineNum = 52;BA.debugLine="B4XPages.ShowPage(\"mainpage\")";
_b4xpages._showpage /*String*/ (ba,"mainpage");
 //BA.debugLineNum = 53;BA.debugLine="ToastMessageShow(\"Note added.\", True)";
__c.ToastMessageShow(BA.ObjectToCharSequence("Note added."),__c.True);
 //BA.debugLineNum = 55;BA.debugLine="ImageCon.Load(File.DirAssets, \"image.jpg\")";
_imagecon._load /*String*/ (__c.File.getDirAssets(),"image.jpg");
 //BA.debugLineNum = 56;BA.debugLine="titleInput.Text = \"\"";
_titleinput.setText(BA.ObjectToCharSequence(""));
 //BA.debugLineNum = 57;BA.debugLine="contentInput.Text = \"\"";
_contentinput.setText(BA.ObjectToCharSequence(""));
 };
 //BA.debugLineNum = 59;BA.debugLine="End Sub";
return "";
}
public String  _b4xpage_created(anywheresoftware.b4a.objects.B4XViewWrapper _root1) throws Exception{
b4a.example.b4xpagesmanager._b4amenuitem _savebtn = null;
 //BA.debugLineNum = 21;BA.debugLine="Private Sub B4XPage_Created (Root1 As B4XView)";
 //BA.debugLineNum = 22;BA.debugLine="Root = Root1";
_root = _root1;
 //BA.debugLineNum = 24;BA.debugLine="Root.LoadLayout(\"newNoteLayout\")";
_root.LoadLayout("newNoteLayout",ba);
 //BA.debugLineNum = 25;BA.debugLine="B4XPages.SetTitle(Me, \"Create\")";
_b4xpages._settitle /*String*/ (ba,this,(Object)("Create"));
 //BA.debugLineNum = 26;BA.debugLine="ImageCon.Load(File.DirAssets, \"image.jpg\")";
_imagecon._load /*String*/ (__c.File.getDirAssets(),"image.jpg");
 //BA.debugLineNum = 29;BA.debugLine="Dim saveBtn As B4AMenuItem = B4XPages.AddMenuItem";
_savebtn = _b4xpages._addmenuitem /*b4a.example.b4xpagesmanager._b4amenuitem*/ (ba,this,(Object)("🗒️ Save"));
 //BA.debugLineNum = 30;BA.debugLine="saveBtn.AddToBar = True";
_savebtn.AddToBar /*boolean*/  = __c.True;
 //BA.debugLineNum = 32;BA.debugLine="CC.Initialize(\"CC\")";
_cc.Initialize("CC");
 //BA.debugLineNum = 33;BA.debugLine="End Sub";
return "";
}
public String  _b4xpage_disappear() throws Exception{
 //BA.debugLineNum = 66;BA.debugLine="Sub b4xpage_disappear";
 //BA.debugLineNum = 67;BA.debugLine="imagePath = \"null\"";
_imagepath = "null";
 //BA.debugLineNum = 68;BA.debugLine="ImageCon.Load(File.DirAssets, \"image.jpg\")";
_imagecon._load /*String*/ (__c.File.getDirAssets(),"image.jpg");
 //BA.debugLineNum = 69;BA.debugLine="End Sub";
return "";
}
public String  _b4xpage_menuclick(String _tag) throws Exception{
 //BA.debugLineNum = 35;BA.debugLine="Sub b4xpage_MenuClick (Tag As String)";
 //BA.debugLineNum = 36;BA.debugLine="If Tag = \"🗒️ Save\" Then";
if ((_tag).equals("🗒️ Save")) { 
 //BA.debugLineNum = 37;BA.debugLine="AddNote";
_addnote();
 };
 //BA.debugLineNum = 39;BA.debugLine="End Sub";
return "";
}
public String  _cc_result(boolean _success,String _dir,String _filename) throws Exception{
 //BA.debugLineNum = 77;BA.debugLine="Sub CC_Result (Success As Boolean, Dir As String,";
 //BA.debugLineNum = 78;BA.debugLine="DateTime.DateFormat=\"hh:mm:ss\"";
__c.DateTime.setDateFormat("hh:mm:ss");
 //BA.debugLineNum = 80;BA.debugLine="If Success = True Then";
if (_success==__c.True) { 
 //BA.debugLineNum = 81;BA.debugLine="ImageCon.Load(Dir, FileName)";
_imagecon._load /*String*/ (_dir,_filename);
 //BA.debugLineNum = 82;BA.debugLine="imagePath = \"image\" & DateTime.Date(DateTime.now";
_imagepath = "image"+__c.DateTime.Date(__c.DateTime.getNow())+".jpg";
 //BA.debugLineNum = 84;BA.debugLine="File.Copy(Dir, FileName, File.DirInternal, image";
__c.File.Copy(_dir,_filename,__c.File.getDirInternal(),_imagepath);
 }else {
 //BA.debugLineNum = 86;BA.debugLine="ToastMessageShow(\"No Success :(\",True)";
__c.ToastMessageShow(BA.ObjectToCharSequence("No Success :("),__c.True);
 };
 //BA.debugLineNum = 88;BA.debugLine="End Sub";
return "";
}
public String  _class_globals() throws Exception{
 //BA.debugLineNum = 1;BA.debugLine="Sub Class_Globals";
 //BA.debugLineNum = 2;BA.debugLine="Private Root As B4XView 'ignore";
_root = new anywheresoftware.b4a.objects.B4XViewWrapper();
 //BA.debugLineNum = 3;BA.debugLine="Private xui As XUI 'ignore'";
_xui = new anywheresoftware.b4a.objects.B4XViewWrapper.XUI();
 //BA.debugLineNum = 4;BA.debugLine="Dim mainpage As B4XMainPage";
_mainpage = new b4a.example.b4xmainpage();
 //BA.debugLineNum = 6;BA.debugLine="Private uploadImgBtn As Button";
_uploadimgbtn = new anywheresoftware.b4a.objects.ButtonWrapper();
 //BA.debugLineNum = 7;BA.debugLine="Private contentInput As EditText";
_contentinput = new anywheresoftware.b4a.objects.EditTextWrapper();
 //BA.debugLineNum = 8;BA.debugLine="Private titleInput As EditText";
_titleinput = new anywheresoftware.b4a.objects.EditTextWrapper();
 //BA.debugLineNum = 10;BA.debugLine="Private ImageCon As B4XImageView";
_imagecon = new b4a.example.b4ximageview();
 //BA.debugLineNum = 11;BA.debugLine="Dim CC As ContentChooser";
_cc = new anywheresoftware.b4a.phone.Phone.ContentChooser();
 //BA.debugLineNum = 12;BA.debugLine="Dim imagePath As String = Null";
_imagepath = BA.ObjectToString(__c.Null);
 //BA.debugLineNum = 13;BA.debugLine="End Sub";
return "";
}
public Object  _initialize(anywheresoftware.b4a.BA _ba) throws Exception{
innerInitialize(_ba);
 //BA.debugLineNum = 16;BA.debugLine="Public Sub Initialize As Object";
 //BA.debugLineNum = 17;BA.debugLine="Return Me";
if (true) return this;
 //BA.debugLineNum = 18;BA.debugLine="End Sub";
return null;
}
public String  _pagetransition() throws Exception{
 //BA.debugLineNum = 61;BA.debugLine="Sub pageTransition";
 //BA.debugLineNum = 62;BA.debugLine="Root.Visible = False";
_root.setVisible(__c.False);
 //BA.debugLineNum = 63;BA.debugLine="Root.SetVisibleAnimated(500, True)";
_root.SetVisibleAnimated((int) (500),__c.True);
 //BA.debugLineNum = 64;BA.debugLine="End Sub";
return "";
}
public String  _uploadimgbtn_click() throws Exception{
 //BA.debugLineNum = 73;BA.debugLine="Private Sub uploadImgBtn_Click";
 //BA.debugLineNum = 74;BA.debugLine="CC.Show(\"image/*\", \"Choose image\")";
_cc.Show(ba,"image/*","Choose image");
 //BA.debugLineNum = 75;BA.debugLine="End Sub";
return "";
}
public Object callSub(String sub, Object sender, Object[] args) throws Exception {
BA.senderHolder.set(sender);
if (BA.fastSubCompare(sub, "B4XPAGE_CREATED"))
	return _b4xpage_created((anywheresoftware.b4a.objects.B4XViewWrapper) args[0]);
return BA.SubDelegator.SubNotFound;
}
}
