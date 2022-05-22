B4A=true
Group=Default Group
ModulesStructureVersion=1
Type=Class
Version=11.5
@EndOfDesignText@
Sub Class_Globals
	Private Root As B4XView 'ignore
	Private xui As XUI 'ignore'
	Dim mainpage As B4XMainPage
	
	Private uploadImgBtn As Button
	Private contentInput As EditText
	Private titleInput As EditText

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
	Root.LoadLayout("newNoteLayout")
	B4XPages.SetTitle(Me, "Create")
	ImageCon.Load(File.DirAssets, "image.jpg")
	
	
	Dim saveBtn As B4AMenuItem = B4XPages.AddMenuItem(Me, "🗒️ Save")
	saveBtn.AddToBar = True
	
	CC.Initialize("CC")
End Sub

Sub b4xpage_MenuClick (Tag As String)
	If Tag = "🗒️ Save" Then
		AddNote
	End If
End Sub

Sub AddNote	
	If contentInput.Text = "" Or titleInput.Text = "" Then
		ToastMessageShow("Please fill out the fields", True)
	Else		
		If imagePath = Null Then
			Starter.SQL1.ExecNonQuery("INSERT INTO notes (title, body) VALUES ('"& titleInput.Text &"', '"& contentInput.Text &")")
		Else
			Starter.SQL1.ExecNonQuery("INSERT INTO notes (title, body, image) VALUES ('"& titleInput.Text &"', '"& contentInput.Text &"', '"& imagePath &"')")
		End If
		
		mainpage.Initialize
		B4XPages.ShowPage("mainpage")
		ToastMessageShow("Note added.", True)
		
		ImageCon.Load(File.DirAssets, "image.jpg")
		titleInput.Text = ""
		contentInput.Text = ""
	End If
End Sub

Sub pageTransition
	Root.Visible = False
	Root.SetVisibleAnimated(500, True)
End Sub

Sub b4xpage_disappear
	imagePath = "null"
	ImageCon.Load(File.DirAssets, "image.jpg")
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



