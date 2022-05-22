package b4a.example;


import anywheresoftware.b4a.BA;
import anywheresoftware.b4a.B4AClass;
import anywheresoftware.b4a.BALayout;
import anywheresoftware.b4a.debug.*;

public class note extends B4AClass.ImplB4AClass implements BA.SubDelegator{
    private static java.util.HashMap<String, java.lang.reflect.Method> htSubs;
    private void innerInitialize(BA _ba) throws Exception {
        if (ba == null) {
            ba = new BA(_ba, this, htSubs, "b4a.example.note");
            if (htSubs == null) {
                ba.loadHtSubs(this.getClass());
                htSubs = ba.htSubs;
            }
            
        }
        if (BA.isShellModeRuntimeCheck(ba)) 
			   this.getClass().getMethod("_class_globals", b4a.example.note.class).invoke(this, new Object[] {null});
        else
            ba.raiseEvent2(null, true, "class_globals", false);
    }

 public anywheresoftware.b4a.keywords.Common __c = null;
public anywheresoftware.b4a.objects.B4XViewWrapper _root = null;
public anywheresoftware.b4a.objects.B4XViewWrapper.XUI _xui = null;
public anywheresoftware.b4a.sql.SQL.CursorWrapper _sqlcursor = null;
public b4a.example.b4xmainpage _mainpage = null;
public b4a.example.edit_note _editnotepage = null;
public anywheresoftware.b4a.objects.LabelWrapper _body = null;
public anywheresoftware.b4a.objects.LabelWrapper _title = null;
public b4a.example.b4ximageview _imagecon = null;
public b4a.example.dateutils _dateutils = null;
public b4a.example.main _main = null;
public b4a.example.starter _starter = null;
public b4a.example.b4xpages _b4xpages = null;
public b4a.example.b4xcollections _b4xcollections = null;
public b4a.example.xuiviewsutils _xuiviewsutils = null;
public String  _b4xpage_appear() throws Exception{
String _imagepath = "";
 //BA.debugLineNum = 65;BA.debugLine="Sub b4xpage_appear";
 //BA.debugLineNum = 66;BA.debugLine="Dim imagePath";
_imagepath = "";
 //BA.debugLineNum = 68;BA.debugLine="sqlCursor = Starter.SQL1.ExecQuery(\"SELECT * FROM";
_sqlcursor = (anywheresoftware.b4a.sql.SQL.CursorWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.sql.SQL.CursorWrapper(), (android.database.Cursor)(_starter._sql1 /*anywheresoftware.b4a.sql.SQL*/ .ExecQuery("SELECT * FROM notes WHERE id = '"+_b4xpages._mainpage /*b4a.example.b4xmainpage*/ (ba)._noteid /*String*/ +"' ")));
 //BA.debugLineNum = 69;BA.debugLine="sqlCursor.Position = 0";
_sqlcursor.setPosition((int) (0));
 //BA.debugLineNum = 71;BA.debugLine="Title.Text = sqlCursor.GetString(\"title\")";
_title.setText(BA.ObjectToCharSequence(_sqlcursor.GetString("title")));
 //BA.debugLineNum = 72;BA.debugLine="Body.Text = sqlCursor.GetString(\"body\")";
_body.setText(BA.ObjectToCharSequence(_sqlcursor.GetString("body")));
 //BA.debugLineNum = 73;BA.debugLine="imagePath = sqlCursor.GetString(\"image\")";
_imagepath = _sqlcursor.GetString("image");
 //BA.debugLineNum = 75;BA.debugLine="If imagePath = \"null\" Then";
if ((_imagepath).equals("null")) { 
 //BA.debugLineNum = 76;BA.debugLine="ImageCon.Load(File.DirAssets, \"bg.jpg\")";
_imagecon._load /*String*/ (__c.File.getDirAssets(),"bg.jpg");
 }else {
 //BA.debugLineNum = 78;BA.debugLine="ImageCon.Load(File.DirInternal, imagePath)";
_imagecon._load /*String*/ (__c.File.getDirInternal(),_imagepath);
 };
 //BA.debugLineNum = 80;BA.debugLine="End Sub";
return "";
}
public String  _b4xpage_created(anywheresoftware.b4a.objects.B4XViewWrapper _root1) throws Exception{
b4a.example.b4xpagesmanager._b4amenuitem _editbtn = null;
b4a.example.b4xpagesmanager._b4amenuitem _deletebtn = null;
 //BA.debugLineNum = 21;BA.debugLine="Private Sub B4XPage_Created (Root1 As B4XView)";
 //BA.debugLineNum = 22;BA.debugLine="Root = Root1";
_root = _root1;
 //BA.debugLineNum = 24;BA.debugLine="Root.LoadLayout(\"noteLayout\")";
_root.LoadLayout("noteLayout",ba);
 //BA.debugLineNum = 26;BA.debugLine="B4XPages.SetTitle(Me, \"\")";
_b4xpages._settitle /*String*/ (ba,this,(Object)(""));
 //BA.debugLineNum = 28;BA.debugLine="Dim editBtn As B4AMenuItem = B4XPages.AddMenuItem";
_editbtn = _b4xpages._addmenuitem /*b4a.example.b4xpagesmanager._b4amenuitem*/ (ba,this,(Object)("Edit"));
 //BA.debugLineNum = 29;BA.debugLine="Dim deleteBtn As B4AMenuItem = B4XPages.AddMenuIt";
_deletebtn = _b4xpages._addmenuitem /*b4a.example.b4xpagesmanager._b4amenuitem*/ (ba,this,(Object)("❌ Delete"));
 //BA.debugLineNum = 31;BA.debugLine="editBtn.AddToBar = True";
_editbtn.AddToBar /*boolean*/  = __c.True;
 //BA.debugLineNum = 32;BA.debugLine="deleteBtn.AddToBar = True";
_deletebtn.AddToBar /*boolean*/  = __c.True;
 //BA.debugLineNum = 34;BA.debugLine="editnotepage.Initialize";
_editnotepage._initialize /*Object*/ (ba);
 //BA.debugLineNum = 36;BA.debugLine="B4XPages.AddPage(\"editnotepage\", editnotepage)";
_b4xpages._addpage /*String*/ (ba,"editnotepage",(Object)(_editnotepage));
 //BA.debugLineNum = 37;BA.debugLine="End Sub";
return "";
}
public String  _b4xpage_disappear() throws Exception{
 //BA.debugLineNum = 61;BA.debugLine="Sub b4xpage_disappear";
 //BA.debugLineNum = 62;BA.debugLine="ImageCon.Load(File.DirAssets, \"bg.jpg\")";
_imagecon._load /*String*/ (__c.File.getDirAssets(),"bg.jpg");
 //BA.debugLineNum = 63;BA.debugLine="End Sub";
return "";
}
public String  _b4xpage_menuclick(String _tag) throws Exception{
 //BA.debugLineNum = 39;BA.debugLine="Sub b4xpage_MenuClick (Tag As String)";
 //BA.debugLineNum = 40;BA.debugLine="If Tag = \"Edit\" Then";
if ((_tag).equals("Edit")) { 
 //BA.debugLineNum = 41;BA.debugLine="B4XPages.ShowPage(\"editnotepage\")";
_b4xpages._showpage /*String*/ (ba,"editnotepage");
 }else if((_tag).equals("❌ Delete")) { 
 //BA.debugLineNum = 43;BA.debugLine="delete_note";
_delete_note();
 };
 //BA.debugLineNum = 45;BA.debugLine="End Sub";
return "";
}
public String  _class_globals() throws Exception{
 //BA.debugLineNum = 1;BA.debugLine="Sub Class_Globals";
 //BA.debugLineNum = 2;BA.debugLine="Private Root As B4XView 'ignore";
_root = new anywheresoftware.b4a.objects.B4XViewWrapper();
 //BA.debugLineNum = 3;BA.debugLine="Private xui As XUI 'ignore";
_xui = new anywheresoftware.b4a.objects.B4XViewWrapper.XUI();
 //BA.debugLineNum = 6;BA.debugLine="Dim sqlCursor As Cursor";
_sqlcursor = new anywheresoftware.b4a.sql.SQL.CursorWrapper();
 //BA.debugLineNum = 7;BA.debugLine="Dim mainpage As B4XMainPage";
_mainpage = new b4a.example.b4xmainpage();
 //BA.debugLineNum = 8;BA.debugLine="Dim editnotepage As edit_note";
_editnotepage = new b4a.example.edit_note();
 //BA.debugLineNum = 10;BA.debugLine="Private Body As Label";
_body = new anywheresoftware.b4a.objects.LabelWrapper();
 //BA.debugLineNum = 11;BA.debugLine="Private Title As Label";
_title = new anywheresoftware.b4a.objects.LabelWrapper();
 //BA.debugLineNum = 12;BA.debugLine="Private ImageCon As B4XImageView";
_imagecon = new b4a.example.b4ximageview();
 //BA.debugLineNum = 13;BA.debugLine="End Sub";
return "";
}
public void  _delete_note() throws Exception{
ResumableSub_delete_note rsub = new ResumableSub_delete_note(this);
rsub.resume(ba, null);
}
public static class ResumableSub_delete_note extends BA.ResumableSub {
public ResumableSub_delete_note(b4a.example.note parent) {
this.parent = parent;
}
b4a.example.note parent;
int _result = 0;

@Override
public void resume(BA ba, Object[] result) throws Exception{

    while (true) {
        switch (state) {
            case -1:
return;

case 0:
//C
this.state = 1;
 //BA.debugLineNum = 48;BA.debugLine="Msgbox2Async(\"Are you sure you want to delete thi";
parent.__c.Msgbox2Async(BA.ObjectToCharSequence("Are you sure you want to delete this note?"),BA.ObjectToCharSequence(""),"Yes","Cancel","No",(anywheresoftware.b4a.objects.drawable.CanvasWrapper.BitmapWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.objects.drawable.CanvasWrapper.BitmapWrapper(), (android.graphics.Bitmap)(parent.__c.Null)),ba,parent.__c.True);
 //BA.debugLineNum = 50;BA.debugLine="Wait For Msgbox_Result (Result As Int)";
parent.__c.WaitFor("msgbox_result", ba, this, null);
this.state = 5;
return;
case 5:
//C
this.state = 1;
_result = (Integer) result[0];
;
 //BA.debugLineNum = 51;BA.debugLine="If Result = DialogResponse.POSITIVE Then";
if (true) break;

case 1:
//if
this.state = 4;
if (_result==parent.__c.DialogResponse.POSITIVE) { 
this.state = 3;
}if (true) break;

case 3:
//C
this.state = 4;
 //BA.debugLineNum = 52;BA.debugLine="Starter.SQL1.ExecNonQuery2(\"DELETE FROM notes WH";
parent._starter._sql1 /*anywheresoftware.b4a.sql.SQL*/ .ExecNonQuery2("DELETE FROM notes WHERE id = ?",anywheresoftware.b4a.keywords.Common.ArrayToList(new Object[]{(Object)(parent._b4xpages._mainpage /*b4a.example.b4xmainpage*/ (ba)._noteid /*String*/ )}));
 //BA.debugLineNum = 54;BA.debugLine="Sleep(1000)";
parent.__c.Sleep(ba,this,(int) (1000));
this.state = 6;
return;
case 6:
//C
this.state = 4;
;
 //BA.debugLineNum = 55;BA.debugLine="mainpage.Initialize";
parent._mainpage._initialize /*String*/ (ba);
 //BA.debugLineNum = 56;BA.debugLine="ToastMessageShow(\"Note deleted.\", True)";
parent.__c.ToastMessageShow(BA.ObjectToCharSequence("Note deleted."),parent.__c.True);
 //BA.debugLineNum = 57;BA.debugLine="B4XPages.ShowPage(\"mainpage\")";
parent._b4xpages._showpage /*String*/ (ba,"mainpage");
 if (true) break;

case 4:
//C
this.state = -1;
;
 //BA.debugLineNum = 59;BA.debugLine="End Sub";
if (true) break;

            }
        }
    }
}
public void  _msgbox_result(int _result) throws Exception{
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
 //BA.debugLineNum = 82;BA.debugLine="Sub pageTransition";
 //BA.debugLineNum = 83;BA.debugLine="Root.Visible = False";
_root.setVisible(__c.False);
 //BA.debugLineNum = 84;BA.debugLine="Root.SetVisibleAnimated(500, True)";
_root.SetVisibleAnimated((int) (500),__c.True);
 //BA.debugLineNum = 85;BA.debugLine="End Sub";
return "";
}
public Object callSub(String sub, Object sender, Object[] args) throws Exception {
BA.senderHolder.set(sender);
if (BA.fastSubCompare(sub, "B4XPAGE_CREATED"))
	return _b4xpage_created((anywheresoftware.b4a.objects.B4XViewWrapper) args[0]);
return BA.SubDelegator.SubNotFound;
}
}
