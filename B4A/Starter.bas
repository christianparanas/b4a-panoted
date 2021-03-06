B4A=true
Group=Default Group
ModulesStructureVersion=1
Type=Service
Version=9.85
@EndOfDesignText@
#Region  Service Attributes 
	#StartAtBoot: False
	#ExcludeFromLibrary: True
#End Region

Sub Process_Globals
	'These global variables will be declared once when the application starts.
	'These variables can be accessed from all modules.
	Dim SQL1 As SQL
End Sub

Sub Service_Create
	'This is the program entry point.
	'This is a good place to load resources that are not specific to a single activity.
	If File.Exists(File.DirInternal, "noteproject.db") = False Then
		File.Copy(File.DirAssets, "noteproject.db", File.DirInternal, "noteproject.db")
	End If
	
	SQL1.Initialize(File.DirInternal, "noteproject.db", True)
End Sub



Sub Service_Start (StartingIntent As Intent)

End Sub

'Return true to allow the OS default exceptions handler to handle the uncaught exception.
Sub Application_Error (Error As Exception, StackTrace As String) As Boolean
	Return True
End Sub

Sub Service_Destroy

End Sub