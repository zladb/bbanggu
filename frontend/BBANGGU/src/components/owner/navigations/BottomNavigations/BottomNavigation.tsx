import { Link, useLocation } from 'react-router-dom';

function BottomNavigation() {
  const location = useLocation();

  const isActive = (path: string) => {
    return location.pathname.startsWith(path);
  };

  return (
    <nav className="fixed bottom-0 left-1/2 -translate-x-1/2 w-full max-w-[480px] bg-white border-t border-gray-200">
      <div className="flex justify-around items-center h-16">
        {/* 내 가게 */}
        <Link 
          to="/owner/store" 
          className={`flex flex-col items-center space-y-1 w-1/3 ${
            isActive('/owner/store') ? 'text-[#FF9B50]' : 'text-gray-400'
          }`}
        >
          <svg className="w-6 h-6" viewBox="0 0 24 24" fill="none" xmlns="http://www.w3.org/2000/svg">
            <path d="M3 12L5 6M5 6H19M5 6L9 20H15L19 6" stroke="currentColor" strokeWidth="2" strokeLinecap="round" strokeLinejoin="round"/>
          </svg>
          <span className="text-xs">내 가게</span>
        </Link>

        {/* 분석 */}
        <Link 
          to="/owner/analysis" 
          className={`flex flex-col items-center space-y-1 w-1/3 ${
            isActive('/owner/analysis') ? 'text-[#FF9B50]' : 'text-gray-400'
          }`}
        >
          <svg className="w-6 h-6" viewBox="0 0 24 24" fill="none" xmlns="http://www.w3.org/2000/svg">
            <path d="M9 17V7M9 17H15M9 17H3M15 17V13M15 17H21M3 7H9M9 7H21" stroke="currentColor" strokeWidth="2" strokeLinecap="round" strokeLinejoin="round"/>
          </svg>
          <span className="text-xs">분석</span>
        </Link>

        {/* 마이 - 경로를 /owner/mypage로 수정 */}
        <Link 
          to="/owner/mypage" 
          className={`flex flex-col items-center space-y-1 w-1/3 ${
            isActive('/owner/mypage') ? 'text-[#FF9B50]' : 'text-gray-400'
          }`}
        >
          <svg className="w-6 h-6" viewBox="0 0 24 24" fill="none" xmlns="http://www.w3.org/2000/svg">
            <path d="M20 21V19C20 16.7909 18.2091 15 16 15H8C5.79086 15 4 16.7909 4 19V21M16 7C16 9.20914 14.2091 11 12 11C9.79086 11 8 9.20914 8 7C8 4.79086 9.79086 3 12 3C14.2091 3 16 4.79086 16 7Z" stroke="currentColor" strokeWidth="2" strokeLinecap="round" strokeLinejoin="round"/>
          </svg>
          <span className="text-xs">마이</span>
        </Link>
      </div>
    </nav>
  );
}

export default BottomNavigation;
