B4A=true
Group=Default Group
ModulesStructureVersion=1
Type=Class
Version=11.5
@EndOfDesignText@
Sub Class_Globals
	Private Root As B4XView 'ignore
	Private xui As XUI 'ignore

	
	Dim sqlCursor As Cursor
	Dim mainpage As B4XMainPage
	Dim editnotepage As edit_note

	Private Body As Label
	Private Title As Label
	Private ImageCon As B4XImageView
End Sub

'You can add more parameters here.
Public Sub Initialize As Object
	Return Me
End Sub

'This event will be called once, before the page becomes visible.
Private Sub B4XPage_Created (Root1 As B4XView)
	Root = Root1
	'load the layout to Root
	Root.LoadLayout("noteLayout")
	
	B4XPages.SetTitle(Me, "")
	
	Dim editBtn As B4AMenuItem = B4XPages.AddMenuItem(Me, "Edit")
	Dim deleteBtn As B4AMenuItem = B4XPages.AddMenuItem(Me, "❌ Delete")
	
	editBtn.AddToBar = True
	deleteBtn.AddToBar = True
	
	editnotepage.Initialize
	
	B4XPages.AddPage("editnotepage", editnotepage)
End Sub

Sub b4xpage_MenuClick (Tag As String)
	If Tag = "Edit" Then
		B4XPages.ShowPage("editnotepage")
	Else If Tag = "❌ Delete" Then
		delete_note
	End If
End Sub

Sub delete_note
	Msgbox2Async("Are you sure you want to delete this note?", "", "Yes", "Cancel", "No", Null, True)
	
	Wait For Msgbox_Result (Result As Int)
	If Result = DialogResponse.POSITIVE Then
		Starter.SQL1.ExecNonQuery2("DELETE FROM notes WHERE id = ?", Array As Object(B4XPages.MainPage.noteId))
	
		Sleep(1000)
		mainpage.Initialize
		ToastMessageShow("Note deleted.", True)
		B4XPages.ShowPage("mainpage")
	End If		
End Sub

Sub b4xpage_disappear
	ImageCon.Load(File.DirAssets, "bg.jpg")
End Sub

Sub b4xpage_appear
	Dim imagePath 
	
	sqlCursor = Starter.SQL1.ExecQuery("SELECT * FROM notes WHERE id = '"& B4XPages.MainPage.noteId &"' ")
	sqlCursor.Position = 0
	
	Title.Text = sqlCursor.GetString("title")
	Body.Text = sqlCursor.GetString("body")
	imagePath = sqlCursor.GetString("image")
	
	If imagePath = "null" Then
		ImageCon.Load(File.DirAssets, "bg.jpg")
	Else
		ImageCon.Load(File.DirInternal, imagePath)
	End If
End Sub

Sub pageTransition
	Root.Visible = False
	Root.SetVisibleAnimated(500, True)
End Sub


'You can see the list of page related events in the B4XPagesManager object. The event name is B4XPage.