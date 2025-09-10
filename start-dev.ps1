# Java開発用PowerShell環境
Set-Location "C:\JavaDev"
Write-Host "🚀 Java開発環境へようこそ！" -ForegroundColor Green
Write-Host "📁 現在のディレクトリ: C:\JavaDev" -ForegroundColor Yellow
Write-Host ""
Write-Host "利用可能なコマンド:" -ForegroundColor Cyan
Write-Host "  idea .                # IntelliJ IDEAでプロジェクト開く"
Write-Host "  claude                # Claude Code起動"
Write-Host "  git init              # Gitリポジトリ初期化"
Write-Host "  mvn archetype:generate # Maven プロジェクト作成"
Write-Host ""
Get-ChildItem -Name | Format-Wide -Column 3
