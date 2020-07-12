#include <string>
using namespace std;
 #include "io.cpp"
 #include <windows.h>


int main(){ 
HWND m_hSel= NULL BOOL CASView::CreateSelWindow(){HWND hWnd=GetSafeHwnd();WNDCLASSEX WndClass;WndClass.cbSize=sizeof(WNDCLASSEX);WndClass.style=CS_HREDRAW | CS_VREDRAW;WndClass.lpfnWndProc=(WNDPROC)SelWindowProc;WndClass.cbClsExtra=0;WndClass.cbWndExtra=0;WndClass.hInstance=AfxGetApp()->m_hInstance;WndClass.hIcon=0l;WndClass.hCursor= NULL WndClass.hbrBackground=(HBRUSH)GetStockObject(GRAY_BRUSH);WndClass.lpszMenuName= NULL WndClass.lpszClassName=_T("SelWindow");WndClass.hIconSm=0l; if (!m_hSel && !RegisterClassEx(&WndClass)){RegisterClass((LPWNDCLASS)&WndClass.style);} if m_hSel)::DestroyWindow(m_m_hSel);m_hSel=CreateWindow(WndClass.lpszClassName,_T("Sel Window"),WS_VISIBLE,50,50,50,50,hWnd, NULL AfxGetApp()->m_hInstance, NULL ; return TRUE;}//----------------------------------LRESULT CALLBACK SelWindowProc(HWND hWnd,UINT uMessage,UINT wParam,LONG lParam){ return DefWindowProc(hWnd,uMessage,wParam,lParam);}m_wndMy.SubclassWindow(m_hSel);m_wndMy//--
return 0;
 }
