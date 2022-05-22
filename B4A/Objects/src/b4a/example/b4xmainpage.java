package b4a.example;


import anywheresoftware.b4a.BA;
import anywheresoftware.b4a.B4AClass;
import anywheresoftware.b4a.BALayout;
import anywheresoftware.b4a.debug.*;

public class b4xmainpage extends B4AClass.ImplB4AClass implements BA.SubDelegator{
    private static java.util.HashMap<String, java.lang.reflect.Method> htSubs;
    private void innerInitialize(BA _ba) throws Exception {
        if (ba == null) {
            ba = new BA(_ba, this, htSubs, "b4a.example.b4xmainpage");
            if (htSubs == null) {
                ba.loadHtSubs(this.getClass());
                htSubs = ba.htSubs;
            }
            
        }
        if (BA.isShellModeRuntimeCheck(ba)) 
			   this.getClass().getMethod("_class_globals", b4a.example.b4xmainpage.class).invoke(this, new Object[] {null});
        else
            ba.raiseEvent2(null, true, "class_globals", false);
    }

 public anywheresoftware.b4a.keywords.Common __c = null;
public anywheresoftware.b4a.objects.B4XViewWrapper _root = null;
public anywheresoftware.b4a.objects.B4XViewWrapper.XUI _xui = null;
public anywheresoftware.b4a.sql.SQL.CursorWrapper _sqlcursor = null;
public b4a.example.note _notepage = null;
public b4a.example.new_note _newnotepage = null;
public b4a.example3.customlistview _notesview = null;
public anywheresoftware.b4a.objects.LabelWrapper _notepreviewcontent = null;
public anywheresoftware.b4a.objects.LabelWrapper _notetitle = null;
public String _noteid = "";
public b4a.example.dateutils _dateutils = null;
public b4a.example.main _main = null;
public b4a.example.starter _starter = null;
public b4a.example.b4xpages _b4xpages = null;
public b4a.example.b4xcollections _b4xcollections = null;
public b4a.example.xuiviewsutils _xuiviewsutils = null;
public String  _b4xpage_appear() throws Exception{
 //BA.debugLineNum = 51;BA.debugLine="Sub B4XPage_Appear";
 //BA.debugLineNum = 52;BA.debugLine="LoadNotes";
_loadnotes();
 //BA.debugLineNum = 53;BA.debugLine="End Sub";
return "";
}
public String  _b4xpage_created(anywheresoftware.b4a.objects.B4XViewWrapper _root1) throws Exception{
b4a.example.b4xpagesmanager._b4amenuitem _newnotebtn = null;
b4a.example.b4xpagesmanager._b4amenuitem _userbtn = null;
 //BA.debugLineNum = 28;BA.debugLine="Private Sub B4XPage_Created (Root1 As B4XView)";
 //BA.debugLineNum = 29;BA.debugLine="Root = Root1";
_root = _root1;
 //BA.debugLineNum = 30;BA.debugLine="Root.LoadLayout(\"MainPage\")";
_root.LoadLayout("MainPage",ba);
 //BA.debugLineNum = 32;BA.debugLine="B4XPages.SetTitle(Me, \"📝 Notes\")";
_b4xpages._settitle /*String*/ (ba,this,(Object)("📝 Notes"));
 //BA.debugLineNum = 33;BA.debugLine="B4XPages.GetManager.TransitionAnimationDuration =";
_b4xpages._getmanager /*b4a.example.b4xpagesmanager*/ (ba)._transitionanimationduration /*int*/  = (int) (0);
 //BA.debugLineNum = 36;BA.debugLine="Dim newNoteBtn As B4AMenuItem = B4XPages.AddMenuI";
_newnotebtn = _b4xpages._addmenuitem /*b4a.example.b4xpagesmanager._b4amenuitem*/ (ba,this,(Object)("➕ Add note"));
 //BA.debugLineNum = 37;BA.debugLine="newNoteBtn.AddToBar = True";
_newnotebtn.AddToBar /*boolean*/  = __c.True;
 //BA.debugLineNum = 39;BA.debugLine="Dim userBtn As B4AMenuItem = B4XPages.AddMenuItem";
_userbtn = _b4xpages._addmenuitem /*b4a.example.b4xpagesmanager._b4amenuitem*/ (ba,this,(Object)(""));
 //BA.debugLineNum = 40;BA.debugLine="userBtn.AddToBar = True";
_userbtn.AddToBar /*boolean*/  = __c.True;
 //BA.debugLineNum = 41;BA.debugLine="userBtn.Bitmap = xui.LoadBitmapResize(File.DirAss";
_userbtn.Bitmap /*anywheresoftware.b4a.objects.B4XViewWrapper.B4XBitmapWrapper*/  = _xui.LoadBitmapResize(__c.File.getDirAssets(),"me.png",__c.DipToCurrent((int) (64)),__c.DipToCurrent((int) (64)),__c.True);
 //BA.debugLineNum = 43;BA.debugLine="notepage.Initialize";
_notepage._initialize /*Object*/ (ba);
 //BA.debugLineNum = 44;BA.debugLine="newnotepage.Initialize";
_newnotepage._initialize /*Object*/ (ba);
 //BA.debugLineNum = 46;BA.debugLine="B4XPages.AddPage(\"notepage\", notepage)";
_b4xpages._addpage /*String*/ (ba,"notepage",(Object)(_notepage));
 //BA.debugLineNum = 47;BA.debugLine="B4XPages.AddPage(\"newnotepage\", newnotepage)";
_b4xpages._addpage /*String*/ (ba,"newnotepage",(Object)(_newnotepage));
 //BA.debugLineNum = 49;BA.debugLine="End Sub";
return "";
}
public String  _b4xpage_disappear() throws Exception{
 //BA.debugLineNum = 55;BA.debugLine="Sub B4XPage_Disappear";
 //BA.debugLineNum = 56;BA.debugLine="notesView.Clear()";
_notesview._clear();
 //BA.debugLineNum = 57;BA.debugLine="End Sub";
return "";
}
public String  _b4xpage_menuclick(String _tag) throws Exception{
 //BA.debugLineNum = 85;BA.debugLine="Sub b4xpage_MenuClick (Tag As String)";
 //BA.debugLineNum = 86;BA.debugLine="If Tag = \"➕ Add note\" Then";
if ((_tag).equals("➕ Add note")) { 
 //BA.debugLineNum = 87;BA.debugLine="B4XPages.ShowPage(\"newnotepage\")";
_b4xpages._showpage /*String*/ (ba,"newnotepage");
 //BA.debugLineNum = 88;BA.debugLine="newnotepage.pageTransition";
_newnotepage._pagetransition /*String*/ ();
 };
 //BA.debugLineNum = 90;BA.debugLine="End Sub";
return "";
}
public String  _class_globals() throws Exception{
 //BA.debugLineNum = 8;BA.debugLine="Sub Class_Globals";
 //BA.debugLineNum = 9;BA.debugLine="Private Root As B4XView";
_root = new anywheresoftware.b4a.objects.B4XViewWrapper();
 //BA.debugLineNum = 10;BA.debugLine="Private xui As XUI";
_xui = new anywheresoftware.b4a.objects.B4XViewWrapper.XUI();
 //BA.debugLineNum = 11;BA.debugLine="Dim sqlCursor As Cursor";
_sqlcursor = new anywheresoftware.b4a.sql.SQL.CursorWrapper();
 //BA.debugLineNum = 13;BA.debugLine="Dim notepage As note";
_notepage = new b4a.example.note();
 //BA.debugLineNum = 14;BA.debugLine="Dim newnotepage As new_note";
_newnotepage = new b4a.example.new_note();
 //BA.debugLineNum = 16;BA.debugLine="Private notesView As CustomListView";
_notesview = new b4a.example3.customlistview();
 //BA.debugLineNum = 17;BA.debugLine="Private NotePreviewContent As Label";
_notepreviewcontent = new anywheresoftware.b4a.objects.LabelWrapper();
 //BA.debugLineNum = 18;BA.debugLine="Private NoteTitle As Label";
_notetitle = new anywheresoftware.b4a.objects.LabelWrapper();
 //BA.debugLineNum = 20;BA.debugLine="Public noteId As String";
_noteid = "";
 //BA.debugLineNum = 21;BA.debugLine="End Sub";
return "";
}
public String  _initialize(anywheresoftware.b4a.BA _ba) throws Exception{
innerInitialize(_ba);
 //BA.debugLineNum = 23;BA.debugLine="Public Sub Initialize";
 //BA.debugLineNum = 25;BA.debugLine="End Sub";
return "";
}
public String  _loadnotes() throws Exception{
int _i = 0;
anywheresoftware.b4a.objects.B4XViewWrapper _panel = null;
 //BA.debugLineNum = 60;BA.debugLine="Sub LoadNotes";
 //BA.debugLineNum = 61;BA.debugLine="Dim xui As XUI";
_xui = new anywheresoftware.b4a.objects.B4XViewWrapper.XUI();
 //BA.debugLineNum = 63;BA.debugLine="sqlCursor = Starter.SQL1.ExecQuery(\"SELECT * FROM";
_sqlcursor = (anywheresoftware.b4a.sql.SQL.CursorWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.sql.SQL.CursorWrapper(), (android.database.Cursor)(_starter._sql1 /*anywheresoftware.b4a.sql.SQL*/ .ExecQuery("SELECT * FROM notes ORDER BY id DESC")));
 //BA.debugLineNum = 65;BA.debugLine="If sqlCursor.RowCount = 0 Then";
if (_sqlcursor.getRowCount()==0) { 
 //BA.debugLineNum = 66;BA.debugLine="ToastMessageShow(\"No notes to display\", True)";
__c.ToastMessageShow(BA.ObjectToCharSequence("No notes to display"),__c.True);
 }else {
 //BA.debugLineNum = 68;BA.debugLine="For i = 0 To sqlCursor.RowCount - 1";
{
final int step6 = 1;
final int limit6 = (int) (_sqlcursor.getRowCount()-1);
_i = (int) (0) ;
for (;_i <= limit6 ;_i = _i + step6 ) {
 //BA.debugLineNum = 69;BA.debugLine="sqlCursor.Position = i";
_sqlcursor.setPosition(_i);
 //BA.debugLineNum = 71;BA.debugLine="Dim panel As B4XView = xui.createPanel(\"\")";
_panel = new anywheresoftware.b4a.objects.B4XViewWrapper();
_panel = _xui.CreatePanel(ba,"");
 //BA.debugLineNum = 72;BA.debugLine="panel.SetLayoutAnimated(100, 0, 0, 100%x, 100di";
_panel.SetLayoutAnimated((int) (100),(int) (0),(int) (0),__c.PerXToCurrent((float) (100),ba),__c.DipToCurrent((int) (100)));
 //BA.debugLineNum = 73;BA.debugLine="panel.LoadLayout(\"noteViewItemLayout\")";
_panel.LoadLayout("noteViewItemLayout",ba);
 //BA.debugLineNum = 75;BA.debugLine="notesView.Add(panel, sqlCursor.GetString(\"id\"))";
_notesview._add(_panel,(Object)(_sqlcursor.GetString("id")));
 //BA.debugLineNum = 76;BA.debugLine="NoteTitle.Text = sqlCursor.GetString(\"title\")";
_notetitle.setText(BA.ObjectToCharSequence(_sqlcursor.GetString("title")));
 //BA.debugLineNum = 77;BA.debugLine="NotePreviewContent.Text = sqlCursor.GetString(\"";
_notepreviewcontent.setText(BA.ObjectToCharSequence(_sqlcursor.GetString("body")));
 }
};
 };
 //BA.debugLineNum = 82;BA.debugLine="sqlCursor.Close";
_sqlcursor.Close();
 //BA.debugLineNum = 83;BA.debugLine="End Sub";
return "";
}
public String  _notesview_itemclick(int _index,Object _value) throws Exception{
 //BA.debugLineNum = 93;BA.debugLine="Private Sub notesView_ItemClick (Index As Int, Val";
 //BA.debugLineNum = 94;BA.debugLine="noteId = Value";
_noteid = BA.ObjectToString(_value);
 //BA.debugLineNum = 96;BA.debugLine="B4XPages.ShowPage(\"notepage\")";
_b4xpages._showpage /*String*/ (ba,"notepage");
 //BA.debugLineNum = 97;BA.debugLine="notepage.pageTransition";
_notepage._pagetransition /*String*/ ();
 //BA.debugLineNum = 98;BA.debugLine="End Sub";
return "";
}
public Object callSub(String sub, Object sender, Object[] args) throws Exception {
BA.senderHolder.set(sender);
if (BA.fastSubCompare(sub, "B4XPAGE_CREATED"))
	return _b4xpage_created((anywheresoftware.b4a.objects.B4XViewWrapper) args[0]);
return BA.SubDelegator.SubNotFound;
}
}
