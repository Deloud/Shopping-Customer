package com.shopping.shoppingmallcustomer.customer;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

//개발 중지
@Service
public class UserDaoService {
    private static List<User> users = new ArrayList<>();

    //유저 수
    private static int usersCount = 3;

    //유저 정보들 한눈에 보기
    public List<User> findAll(){
        return users;
    }

    //유저 저장하기 - 없으면 추가
    public User save(User user){
        if (user.getId() == null){
            user.setId(++usersCount);
        }
        users.add(user);
        return user;
    }

    // 이름이나 id로 사람 검색 검색
    public User findOne(String nameorid){
        for (User user : users) {
            if(user.getName().equals(nameorid)){
                return user;
            }
            if(user.getId() == ATOI(nameorid)){
                return user;
            }
        }
        return null;
    }

    public User deleteById(int id){
        Iterator<User> iterator = users.iterator();

        while (iterator.hasNext()){
            User user = iterator.next();

            if (user.getId() == id){ // 있으면
                iterator.remove();
                return user;
            }
        }
        return null; //없으면 Null 반환
    }

    // String이면 int로 바꿔주는 함수
    public static int ATOI(String sTmp)
    {
        String tTmp = "0", cTmp = "";

        sTmp = sTmp.trim();
        for(int i=0;i < sTmp.length();i++)
        {
            cTmp = sTmp.substring(i,i+1);
            if(cTmp.equals("0") ||
                    cTmp.equals("1") ||
                    cTmp.equals("2") ||
                    cTmp.equals("3") ||
                    cTmp.equals("4") ||
                    cTmp.equals("5") ||
                    cTmp.equals("6") ||
                    cTmp.equals("7") ||
                    cTmp.equals("8") ||
                    cTmp.equals("9")) tTmp += cTmp;
            else if(cTmp.equals("-") && i==0)
                tTmp = "-";
            else
                break;
        }
        return(Integer.parseInt(tTmp));
    }
}