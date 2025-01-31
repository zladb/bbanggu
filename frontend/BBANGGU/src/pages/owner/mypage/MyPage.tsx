import { Link } from 'react-router-dom';
import { Bell } from 'lucide-react';
import BottomNavigation from '../../../components/owner/navigations/BottomNavigations/BottomNavigation';


function MyPage() {
  return (
    <div className="min-h-screen bg-white pb-20">
      {/* 헤더 */}
      <div className="flex justify-between items-center px-4 h-14">
        <h1 className="text-lg font-bold">마이페이지</h1>
        <button className="p-2">
          <Bell className="w-6 h-6" />
        </button>
      </div>

      {/* 프로필 섹션 */}
      <div className="px-4 py-6">
        <div className="flex items-center space-x-4">
          <img
            src="/default-profile.png"
            alt="프로필"
            className="w-16 h-16 rounded-full object-cover"
          />
          <div>
            <h2 className="text-lg font-medium">김혜수</h2>
            <p className="text-gray-500 text-sm">오늘도 빵과 함께 할기찬 하루 보내세요~</p>
          </div>
        </div>

        {/* 프로필 수정 버튼들 */}
        <div className="flex gap-3 mt-4">
          <Link 
            to="/owner/profile/edit"
            className="flex-1 py-3 text-center rounded-lg bg-[#FF9B50] text-white"
          >
            회원 정보 수정
          </Link>
          <Link 
            to="/owner/store/edit"
            className="flex-1 py-3 text-center rounded-lg border border-[#FF9B50] text-[#FF9B50]"
          >
            가게 정보 수정
          </Link>
        </div>
      </div>

      {/* 메뉴 리스트 */}
      <div className="px-4 space-y-4">
        {/* 픽업 시간 설정 */}
        <Link 
          to="/owner/pickup-time"
          className="flex items-center justify-between p-4 bg-gray-50 rounded-lg"
        >
          <span>픽업 시간 설정</span>
          <svg className="w-6 h-6 text-gray-400" viewBox="0 0 24 24" fill="none" stroke="currentColor">
            <path d="M12 6v6l4 2" strokeWidth="2" strokeLinecap="round" strokeLinejoin="round"/>
            <circle cx="12" cy="12" r="10" strokeWidth="2"/>
          </svg>
        </Link>

        {/* 거래 및 정산 */}
        <Link 
          to="/owner/settlement/edit"
          className="flex items-center justify-between p-4 bg-gray-50 rounded-lg"
        >
          <span>거래 및 정산</span>
          <svg className="w-6 h-6 text-gray-400" viewBox="0 0 24 24" fill="none" stroke="currentColor">
            <path d="M12 1v22M17 5H9.5a3.5 3.5 0 0 0 0 7h5a3.5 3.5 0 0 1 0 7H6" strokeWidth="2" strokeLinecap="round" strokeLinejoin="round"/>
          </svg>
        </Link>
      </div>

      {/* 고객 지원 서비스 */}
      <div className="mt-8 px-4">
        <h3 className="text-sm text-gray-500 mb-4">고객 지원 서비스</h3>
        <div className="grid grid-cols-2 gap-4">
          <Link 
            to="/owner/qna"
            className="flex flex-col items-center justify-center p-6 bg-gray-50 rounded-lg"
          >
            <svg className="w-6 h-6 text-gray-400 mb-2" viewBox="0 0 24 24" fill="none" stroke="currentColor">
              <path d="M21 11.5a8.38 8.38 0 0 1-.9 3.8 8.5 8.5 0 0 1-7.6 4.7 8.38 8.38 0 0 1-3.8-.9L3 21l1.9-5.7a8.38 8.38 0 0 1-.9-3.8 8.5 8.5 0 0 1 4.7-7.6 8.38 8.38 0 0 1 3.8-.9h.5a8.48 8.48 0 0 1 8 8v.5z" strokeWidth="2" strokeLinecap="round" strokeLinejoin="round"/>
            </svg>
            <span>Q&A</span>
          </Link>
          <Link 
            to="/owner/chatbot"
            className="flex flex-col items-center justify-center p-6 bg-gray-50 rounded-lg"
          >
            <svg className="w-6 h-6 text-gray-400 mb-2" viewBox="0 0 24 24" fill="none" stroke="currentColor">
              <path d="M12 2a10 10 0 0 1 10 10c0 5.523-4.477 10-10 10S2 17.523 2 12 6.477 2 12 2z" strokeWidth="2"/>
              <path d="M12 16v-4M12 8h.01" strokeWidth="2" strokeLinecap="round"/>
            </svg>
            <span>고객센터</span>
          </Link>
        </div>
      </div>

      <BottomNavigation />
    </div>
  );
}

export default MyPage;
