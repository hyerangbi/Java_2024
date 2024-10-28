import React from 'react'
import { UserOutlined } from '@ant-design/icons';
import { Avatar, Card, Space } from 'antd'
import styled from 'styled-components';

const ChatDisplay = ({chatDataList}) => {
  return (
    <ChatContatiner>
        {chatDataList.map((chat, index) => (
            <div key={chat.date}>
                <Space
                    style={{
                        float:'left'
                    }}
                >
                    <Avatar size={30}> UserOutlined </Avatar>
                    <Card
                        style={{
                            width: 300
                        }}
                    >
                        {chat.question}
                    </Card>
                </Space>
                <Space
                    style={{
                        float:'right',
                        margin: "12px 0"
                    }}
                >
                    <Card
                        style={{
                            width: 400
                        }}
                    >
                        {chat.message}
                    </Card>
                    <Avatar 
                        size={40}
                        src={}
                    />
                </Space>
            </div>
        ))}
        {
            isLoading &&
            <LoadingArea>
                AI 응답 작성 중 ...
                <LoadingOutlined />
            </LoadingArea>
        }
    </ChatContatiner>
  )
}

export default ChatDisplay

const ChatContatiner = styled.div`
    display: flex;
    flex-direction: column;
`

const LoadingArea = styled.div`
    padding: 12px 0 24px ;
`