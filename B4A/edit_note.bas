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
	
	Private contentInput As EditText
	Private titleInput  As EditText
	
	Dim notepage As note
	Private ImageCon As B4XImageView
	
	Dim CC As ContentChooser
	Dim imagePath As String = Null
End Sub

'You can add more parameters here.
Public Sub Initialize As Object
	Return Me
End Sub

'This event will be called once, before the page becomes visible.
Private Sub B4XPage_Created (Root1 As B4XView)
	Root = Root1
	'load the layout to Root
	Root.LoadLayout("editnotelayout")
	B4XPages.SetTitle(Me, "Edit")
	
	Dim saveBtn As B4AMenuItem = B4XPages.AddMenuItem(Me, "🗒️ Update")
	saveBtn.AddToBar = True
	
	notepage.Initialize
	B4XPages.AddPage("notepage", notepage)
	
	'setting default image if null'
	ImageCon.Load(File.DirAssets, "image.jpg")
	
	CC.Initialize("CC")
End Sub

Sub b4xpage_appear
	sqlCursor = Starter.SQL1.ExecQuery("SELECT * FROM notes WHERE id = '"& B4XPages.MainPage.noteId &"' ")
	sqlCursor.Position = 0
	
	titleInput.Text = sqlCursor.GetString("title")
	contentInput.Text = sqlCursor.GetString("body")
	
	If sqlCursor.GetString("image") = "null" Then
		ImageCon.Load(File.DirAssets, "image.jpg")
	Else
		If imagePath = "null" Then
			ImageCon.Load(File.DirInternal, sqlCursor.GetString("image"))
		End If
	End If
End Sub

Sub b4xpage_disappear
	imagePath = "null"
End Sub

Sub b4xpage_MenuClick (Tag As String)
	If Tag = "🗒️ Update" Then
		update_note
	End If
End Sub

Sub update_note
	If contentInput.Text = "" Or titleInput.Text = "" Then
		ToastMessageShow("Please fill out the fields", True)
	Else
		If imagePath = "null" Then
			Starter.SQL1.ExecNonQuery2("UPDATE notes SET title = ?, body = ? WHERE id = ?", Array As Object(titleInput.Text, contentInput.Text, B4XPages.MainPage.noteId))
		Else
			Starter.SQL1.ExecNonQuery2("UPDATE notes SET title = ?, body = ?, image = ? WHERE id = ?", Array As Object(titleInput.Text, contentInput.Text, imagePath, B4XPages.MainPage.noteId))
		End If
		
		B4XPages.ShowPage("notepage")
		ToastMessageShow("Note updated.", True)
	End If
	
	
End Sub

'You can see the list of page related events in the B4XPagesManager object. The event name is B4XPage.

Private Sub uploadImgBtn_Click
	CC.Show("image/*", "Choose image")
End Sub

Sub CC_Result (Success As Boolean, Dir As String, FileName As String)
	DateTime.DateFormat="hh:mm:ss"
	
	If Success = True Then
		ImageCon.Load(Dir, FileName)
		imagePath = "image" & DateTime.Date(DateTime.now) & ".jpg"
		
		File.Copy(Dir, FileName, File.DirInternal, imagePath)
	Else
		ToastMessageShow("No Success :(",True)
	End If
End Sub