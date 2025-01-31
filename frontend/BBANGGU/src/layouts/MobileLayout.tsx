import { ReactNode } from 'react';

interface MobileLayoutProps {
  children: ReactNode;
}

function MobileLayout({ children }: MobileLayoutProps) {
  return (
    <div className="w-full min-h-screen bg-white font-['Pretendard']">
      <div className="mx-auto min-w-[300px] max-w-[440px] overflow-x-hidden">
        {children}
      </div>
    </div>
  );
}

export default MobileLayout;