B4A=true
Group=Default Group
ModulesStructureVersion=1
Type=Class
Version=9.85
@EndOfDesignText@
#Region Shared Files
#CustomBuildAction: folders ready, %WINDIR%\System32\Robocopy.exe,"..\..\Shared Files" "..\Files"
'Ctrl + click to sync files: ide://run?file=%WINDIR%\System32\Robocopy.exe&args=..\..\Shared+Files&args=..\Files&FilesSync=True
#End Region

'Ctrl + click to export as zip: ide://run?File=%B4X%\Zipper.jar&Args=Project.zip

Sub Class_Globals
	Private Root As B4XView
	Private xui As XUI
	Dim sqlCursor As Cursor
	
	Dim notepage As note
	Dim newnotepage As new_note
	
	Private notesView As CustomListView
	Private NotePreviewContent As Label
	Private NoteTitle As Label
	
	Public noteId As String
End Sub

Public Sub Initialize
'	B4XPages.GetManager.LogEvents = True
End Sub

'This event will be called once, before the page becomes visible.
Private Sub B4XPage_Created (Root1 As B4XView)
	Root = Root1
	Root.LoadLayout("MainPage")
	
	B4XPages.SetTitle(Me, "📝 Notes")
	B4XPages.GetManager.TransitionAnimationDuration = 0
	
	'Menu items'
	Dim newNoteBtn As B4AMenuItem = B4XPages.AddMenuItem(Me, "➕ Add note")
	newNoteBtn.AddToBar = True
	
	Dim userBtn As B4AMenuItem = B4XPages.AddMenuItem(Me, "")
	userBtn.AddToBar = True
	userBtn.Bitmap = xui.LoadBitmapResize(File.DirAssets, "me.png", 64dip, 64dip, True)
	
	notepage.Initialize
	newnotepage.Initialize
	
	B4XPages.AddPage("notepage", notepage)
	B4XPages.AddPage("newnotepage", newnotepage)
	
End Sub

Sub B4XPage_Appear
	LoadNotes
End Sub

Sub B4XPage_Disappear
	notesView.Clear()
End Sub


Sub LoadNotes
	Dim xui As XUI
		
	sqlCursor = Starter.SQL1.ExecQuery("SELECT * FROM notes ORDER BY id DESC")
	
	If sqlCursor.RowCount = 0 Then
		ToastMessageShow("No notes to display", True)
	Else
		For i = 0 To sqlCursor.RowCount - 1
			sqlCursor.Position = i
			
			Dim panel As B4XView = xui.createPanel("")
			panel.SetLayoutAnimated(100, 0, 0, 100%x, 100dip)
			panel.LoadLayout("noteViewItemLayout")
			
			notesView.Add(panel, sqlCursor.GetString("id"))
			NoteTitle.Text = sqlCursor.GetString("title")
			NotePreviewContent.Text = sqlCursor.GetString("body")
		Next
	End If

	
	sqlCursor.Close
End Sub

Sub b4xpage_MenuClick (Tag As String)
	If Tag = "➕ Add note" Then
		B4XPages.ShowPage("newnotepage")
		newnotepage.pageTransition
	End If
End Sub


Private Sub notesView_ItemClick (Index As Int, Value As Object)
	noteId = Value
	
	B4XPages.ShowPage("notepage")
	notepage.pageTransition
End Sub