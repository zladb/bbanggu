import { ApiResponse } from '../../types/api';

interface UserInfo {
  userId: number;
  name: string;
  email: string;
  phone: string;
  role: string;
  profileImageUrl: string | null;
  addressRoad: string | null;
  addressDetail: string | null;
}

interface UpdateUserRequest {
  name?: string;
  phone?: string;
  addressRoad?: string;
  addressDetail?: string;
}

interface UpdateUserResponse {
  message: string;
  data: null;
}

export const getUserInfo = async (): Promise<UserInfo> => {
  const accessToken = 'eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiIxIiwiaWF0IjoxNzM5NTExOTE5LCJleHAiOjE3NDAxMTY3MTl9.1TANi8zQMdtN3uHUGbcuNunWJxWLZoZPoNZ3uePfiUM'; // 테스트용 토큰
  
  try {
    const response = await fetch('http://i12d102.p.ssafy.io:8081/user', {
      method: 'GET',
      headers: {
        'Authorization': `Bearer ${accessToken}`,
        'Content-Type': 'application/json',
      },
    });

    if (!response.ok) {
      throw new Error('Failed to fetch user info');
    }

    const responseData: ApiResponse<UserInfo> = await response.json();
    return responseData.data;
  } catch (error) {
    console.error('Error fetching user info:', error);
    throw error;
  }
};

export const updateUserInfo = async (data: UpdateUserRequest): Promise<UpdateUserResponse> => {
  const accessToken = 'eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiIxIiwiaWF0IjoxNzM5NTExOTE5LCJleHAiOjE3NDAxMTY3MTl9.1TANi8zQMdtN3uHUGbcuNunWJxWLZoZPoNZ3uePfiUM'; // 테스트용 토큰
  
  try {
    const response = await fetch('http://i12d102.p.ssafy.io:8081/user/update', {
      method: 'PATCH',
      headers: {
        'Authorization': `Bearer ${accessToken}`,
        'Content-Type': 'application/json',
      },
      body: JSON.stringify(data),
    });

    console.log(response)
    if (!response.ok) {
      const errorData = await response.json();
      
      if (response.status === 401) {
        throw new Error('인증이 필요합니다.');
      }
      
      if (response.status === 409) {
        throw new Error('이미 사용 중인 전화번호입니다.');
      }
      
      throw new Error(errorData.message || '회원 정보 수정에 실패했습니다.');
    }

    return await response.json();
  } catch (error) {
    console.error('Error updating user info:', error);
    throw error;
  }
}; 