import { sizes } from '@styles/theme'
import styled from 'styled-components'

export const Container = styled.div`
  background-color: #e1e4ea;
  width: 100%;
  height: 100dvh;
`

export const Title = styled.div`
  font-size: 1.2em;
  font-weight: 600;
  margin-inline: auto;
  padding-block: 60px 10px;
  padding-inline: 5%;
  background-color: #fff;
`

export const Form = styled.form`
  width: 100%;
  min-width: ${sizes.minWidth};
  max-width: ${sizes.maxWidth};
  position: fixed;
  bottom: 0;
  padding: 1em;
  @media only screen and (min-width: 430px) {
    width: 430px;
  }
  @media only screen and (min-width: 600px) {
    width: 375px;
  }
`
