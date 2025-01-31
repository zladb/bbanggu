import { ReactNode } from 'react';

interface MobileLayoutProps {
  children: ReactNode;
}

function MobileLayout({ children }: MobileLayoutProps) {
  return (
    <div className="flex justify-center min-h-screen bg-gray-100">
      <div className="w-full max-w-[480px] mx-auto bg-white min-h-screen relative">
        {children}
      </div>
    </div>
  );
}

export default MobileLayout;